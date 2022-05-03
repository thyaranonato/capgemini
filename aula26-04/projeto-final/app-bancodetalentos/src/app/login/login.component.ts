import { Component, OnInit } from '@angular/core';
import { CadastroService } from '../cadastro.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(private serviceCadastro: CadastroService) {}

  usuarios: any = {}

  usuarioConectado = {
    id: 0,
    nome: '',
    email: '',
    password: '',
    perfil: ''
  };

  ngOnInit(): void {}

  fazerLogin(dados: any) {
    console.log(dados)
    this.serviceCadastro.getAll().subscribe((user) => {
      this.usuarios = user;
      this.verificarLogin(dados.email, dados.password, this.usuarios);
    });
  }

  visible: boolean = true;
  changetype: boolean = true;

  viewPassword() {
    this.visible = !this.visible;
    this.changetype = !this.changetype;
  }

  verificarLogin(email: string, password: string, dados: any) {
    localStorage.removeItem('userConectado');
    for (let i = 0; i < dados.length; i++) {
      if (email == dados[i].email && password == dados[i].password) {
        this.usuarioConectado.id = dados[i].id;
        this.usuarioConectado.nome = dados[i].nome;
        this.usuarioConectado.email = dados[i].email;
        this.usuarioConectado.password = dados[i].password;
        this.usuarioConectado.perfil = dados[i].perfil
        this.gravarDadosLocalStorage();
      }
    }
    window.location.href = 'home';
  }

  gravarDadosLocalStorage() {
    localStorage.setItem('userConectado', JSON.stringify(this.usuarioConectado));
  }

}
