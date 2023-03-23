import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AutenticacaoUsuarioService } from '../services/autenticacaousuario.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AutenticacaoUsuarioService]
})


export class LoginComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
    public autenticacaoUsuarioService: AutenticacaoUsuarioService
  ) {
  }

  ngOnInit(): void {
    console.log("Iniciando a tela de Login");
    
    this.autenticacaoUsuarioService.removeTokens();
    this.form = this.formBuilder.group({
      login: '',
      senha: ''
    });
  }

  submit(): void {

    console.log("Chamando serviço de autenticação");
    this.autenticacaoUsuarioService.validaLogin(this.form)
      .subscribe(success => {
        if (success)
          this.router.navigate(['/apuracao']);
      });
  }
}
