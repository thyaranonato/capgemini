import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { LoginComponent } from './login/login.component';
import { RelatorioVendasComponent } from './relatorio-vendas/relatorio-vendas.component';
import { MessageErrorComponent } from './message-error/message-error.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent,
    ConsultaComponent,
    LoginComponent,
    RelatorioVendasComponent,
    MessageErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
