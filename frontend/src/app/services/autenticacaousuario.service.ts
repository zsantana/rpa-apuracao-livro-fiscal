import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, mapTo, Observable, of, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tokens } from '../models/tokens';
import { FormBuilder, FormGroup } from '@angular/forms';

import { JwtHelperService } from '@auth0/angular-jwt';




@Injectable()
export class AutenticacaoUsuarioService {

    public jwtHelper: JwtHelperService = new JwtHelperService();

    apiURI = environment.api + '/v1/autenticacao/usuario/login/';

    private loggedUser: string | undefined;
    private usuariologado: string | undefined;

    private readonly JWT_TOKEN = 'JWT_TOKEN';
    private readonly REFRESH_TOKEN = 'REFRESH_TOKEN';

    constructor(private http: HttpClient,
        private formBuilder: FormBuilder) { }


    validaLogin(form: FormGroup): Observable<boolean> {
        console.log("================")
        console.log("Validando usário");
        console.log("================")
        return this.http.post<any>(this.apiURI, form.getRawValue())
            .pipe(
                tap(tokens => this.doLoginUser(form.controls['login'].value, tokens)),
                map(x => true),
                catchError(error => {
                    alert("Login ou senha inválido. Tente novamente.");
                    return of(false);
                }));

    }

    logout() {
        console.log("================")
        console.log("Deslogando usário");
        console.log("================")
        return this.http.post<any>(`${this.apiURI}/logout`, {
            'refreshToken': this.getRefreshToken()
        }).pipe(
            tap(() => this.doLogoutUser()),
            map(x => true),
            catchError(error => {
                alert(error.error);
                return of(false);
            }));
    }


    isLoggedIn() {
        return !!this.getJwtToken();
    }


    refreshToken() {
        console.log("================")
        console.log("refreshToken usário");
        console.log("================")
        return this.http.post<any>(`${this.apiURI}/refresh`, {
            'refreshToken': this.getRefreshToken()
        }).pipe(tap((tokens: Tokens) => {
            this.storeJwtToken(tokens.token);
        }));
    }

    getJwtToken() {
        console.log("================")
        console.log("getJwtToken usário");
        console.log("================")
        return localStorage.getItem(this.JWT_TOKEN) || '';
    }

    private doLoginUser(username: string, tokens: Tokens) {
        console.log("usuário: " + username)
        this.loggedUser = username;
        this.storeTokens(tokens);
    }

    private doLogoutUser() {
        this.loggedUser = '';
        this.removeTokens();
    }

    private getRefreshToken() {
        return localStorage.getItem(this.REFRESH_TOKEN);
    }

    private storeJwtToken(jwt: string) {
        localStorage.setItem(this.JWT_TOKEN, jwt);
    }

    private storeTokens(tokens: Tokens) {
        console.log("tokens.token: " + tokens.token)
        localStorage.setItem(this.JWT_TOKEN, tokens.token);
        localStorage.setItem(this.REFRESH_TOKEN, tokens.refreshToken);
    }

    removeTokens() {
        localStorage.removeItem(this.JWT_TOKEN);
        localStorage.removeItem(this.REFRESH_TOKEN);
    }


    isTokenExpired() {

        const token = localStorage.getItem("JWT_TOKEN");
        console.log("TOKEN: " + token);

        if (token && !this.jwtHelper.isTokenExpired(token)) {
            console.log("### Token válido");
            return true;
        }

        alert("O tempo a sessão expirou. Faça um novo login.");
        console.log("### Token INVÁLIDO");
        this.removeTokens();

        return false;

    }


}
