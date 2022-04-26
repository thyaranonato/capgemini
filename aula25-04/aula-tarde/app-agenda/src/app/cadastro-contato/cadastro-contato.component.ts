import { Component } from '@angular/core';

@Component({
  selector: 'app-cadastro-contato',
  templateUrl: './cadastro-contato.component.html',
  styleUrls: ['./cadastro-contato.component.css']
})
export class CadastroContatoComponent {

  contatos = [{
    id: 1,
    nome: "Ana",
    email: "ana@gmail.com",
    fone: "123456789"
  },
  {
    id: 2,
    nome: "Pedro",
    email: "pedro@gmail.com",
    fone: "123456789"
  },
  {
    id: 3,
    nome: "João",
    email: "joão@gmail.com",
    fone: "123456789"
  },
  {
    id: 4,
    nome: "Paula",
    email: "paula@gmail.com",
    fone: "123456789"
  }
]

  constructor() { }

  saveContato(data: any) {
    data.id = this.contatos.length +1;
    this.contatos.push(data);
  }

}
