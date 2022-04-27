import { Component } from '@angular/core';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private serviceUsuario: UsuarioService) { }
  usuarios: any = [];

  usuarioConectado = {
    id: 0,
    nome: "",
    email: "",
    senha: "",
    perfil: ""
  }

  login(data: any) {
    this.serviceUsuario.getAll().subscribe(response => {this.usuarios = response
    this.verificarLogin(data.email, data.senha, this.usuarios)
    });
  }

  verificarLogin(email: string, senha: string, data: any) {
    for(let i = 0; i < data.length; i++) {
      if(email === data[i].email && senha === data[i].senha) {
        this.usuarioConectado.id = data[i].id,
        this.usuarioConectado.nome = data[i].nome,
        this.usuarioConectado.email = data[i].email,
        this.usuarioConectado.senha = data[i].senha,
        this.usuarioConectado.perfil = data[i].perfil
      }
    }
  }
}
