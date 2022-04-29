import { Component } from '@angular/core';
import { IProduto } from '../interfaces/IProduto';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})
export class CadastroProdutoComponent {
  frase: string = "Olá pessoal, tudo bem?";
  
  produto: IProduto = {
    id: 0,
    descricao: "Arroz integral",
    preco: 8.54,
    estoque: 100
  }

  hoje = new Date();

  descricao: string = "";

  constructor() { }

}
