import { PerfilComponent } from './perfil/perfil.component';
import { LoginComponent } from './login/login.component';
import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { PaginaPrincipalComponent } from './pagina-principal/pagina-principal.component';

const routes: Routes = [
  {
    path: 'cadastro',
    component: CadastroComponent
  },
  {
    path: 'consulta',
    component: ConsultaComponent
  },
  {
    path: 'home',
    component: PaginaPrincipalComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'perfil/:idtalento',
    component: PerfilComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
