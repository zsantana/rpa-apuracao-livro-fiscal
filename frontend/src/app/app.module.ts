import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { ToastrModule } from 'ngx-toastr';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

import { AppComponent } from './app.component';
import { AuthModuleGuard } from './auth/auth.module';
import { AppRoutingModule } from './app-routing.module';
import { ElementDialogComponent } from './shared/element-dialog/element-dialog.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HeaderComponent } from './shared/header/header.component';

import { ApuracaoComponent } from './apuracao/apuracao.component';
import { RegisterComponent } from './register/register.component';
import { Erro404Component } from './ErroCode/erro404.component';


@NgModule({
  declarations: [
    AppComponent,
    ApuracaoComponent,
    RegisterComponent,
    ElementDialogComponent,
    FooterComponent,
    HeaderComponent,
    Erro404Component
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,
    MatTableModule,
    MatIconModule,
    MatDialogModule,
    AuthModuleGuard,
    ToastrModule.forRoot({
      timeOut: 150000, // 15 seconds
      closeButton: true,
      progressBar: true,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
