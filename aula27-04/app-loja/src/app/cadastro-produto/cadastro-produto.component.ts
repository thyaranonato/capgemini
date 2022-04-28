import { Component } from '@angular/core';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})
export class CadastroProdutoComponent {

  constructor(private serviceProduto: ProdutoService) { 
    this.serviceProduto.getAll().subscribe(response => this.produtos = response);
  }
  msg: string = "";
  produtos: any;

  gravar(data: any) {
    this.serviceProduto.gravar(data).subscribe(response => this.msg = "Produto cadastrado com sucesso!");
  }

  limparMsg() {
    this.msg = "";
  }

  excluir(id: any) {
    this.serviceProduto.delete(id).subscribe(response => {window.location.reload()});
  }
}
