import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { TokenInterceptor } from './token.interceptor';
import { AutenticacaoUsuarioService } from '../services/autenticacaousuario.service';
import { ApuracaoGuard } from './apuracao.guard';
import { LoginComponent } from '../login/login.component';

@NgModule({
  declarations: [LoginComponent],
  providers: [
    AutenticacaoUsuarioService,
    
    ApuracaoGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
  ]
})
export class AuthModuleGuard { }