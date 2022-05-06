import { LoginComponent } from './login/login.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultaComponent } from './consulta/consulta.component';
import { AuthguardService } from './authguard.service';

const routes: Routes = [
  {
    path: 'cadastro',
    component: CadastroComponent,
    canActivate: [AuthguardService]
  },
  {
    path: 'consulta',
    component: ConsultaComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
