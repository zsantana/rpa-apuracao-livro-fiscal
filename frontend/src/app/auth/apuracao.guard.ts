import { Injectable } from '@angular/core';
import { CanActivate, CanLoad, Router } from '@angular/router';
import { AutenticacaoUsuarioService } from 'src/app/services/autenticacaousuario.service';

@Injectable({
  providedIn: 'root'
})
export class ApuracaoGuard implements CanActivate {

  constructor(private authService: AutenticacaoUsuarioService, private router: Router) { }

  canActivate() {

    console.log("### ApuracaoGuard.canActivate");

    if(!this.authService.isTokenExpired()){
      this.router.navigate(['/login']);
      return false;
    }else{
      return true;
    }
  }
}
