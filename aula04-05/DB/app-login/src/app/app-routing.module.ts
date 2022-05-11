import { MessageErrorComponent } from './message-error/message-error.component';
import { LoginComponent } from './login/login.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultaComponent } from './consulta/consulta.component';
import { AuthLogin } from './auth-login.service';
import { RelatorioVendasComponent } from './relatorio-vendas/relatorio-vendas.component';
import { AuthAdm } from './auth-adm.service';

const routes: Routes = [
  {
    path: 'cadastro',
    component: CadastroComponent,
    canActivate: [AuthLogin]
  },
  {
    path: 'consulta',
    component: ConsultaComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'relatorio',
    component: RelatorioVendasComponent,
    canActivate: [AuthAdm]
  },
  {
    path: 'message-error',
    component: MessageErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
