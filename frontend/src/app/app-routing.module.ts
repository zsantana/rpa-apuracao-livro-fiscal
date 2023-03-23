import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApuracaoComponent } from './apuracao/apuracao.component';
import { RegisterComponent } from './register/register.component';
import { Erro404Component } from './ErroCode/erro404.component';
import { LoginComponent } from './login/login.component';
import { ApuracaoGuard } from './auth/apuracao.guard';

const routes: Routes = [

  { path: '', pathMatch: 'full', redirectTo: '/login' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  //{path: 'apuracao', component: ApuracaoComponent, canActivate: [ApuracaoGuard]},
  { path: 'apuracao', component: ApuracaoComponent,  canActivate: [ApuracaoGuard]},
  { path: '**', component: Erro404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
