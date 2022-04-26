import { Component } from '@angular/core';

@Component({
  selector: 'app-consulta-contato',
  templateUrl: './consulta-contato.component.html',
  styleUrls: ['./consulta-contato.component.css']
})
export class ConsultaContatoComponent {
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

}
