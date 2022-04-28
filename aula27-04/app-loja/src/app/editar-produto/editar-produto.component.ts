import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-editar-produto',
  templateUrl: './editar-produto.component.html',
  styleUrls: ['./editar-produto.component.css']
})
export class EditarProdutoComponent implements OnInit {

  constructor(private route: ActivatedRoute, private serviceProduto: ProdutoService) { }
  produto: any;
  msg: string = "";

  ngOnInit(): void {
    let routeParams = this.route.snapshot.paramMap;
    let idProduto: number = Number(routeParams.get('idProduto'));
    this.serviceProduto.getOne(idProduto).subscribe(response => this.produto = response);
  }

  efetivarAlteracao() {
    this.serviceProduto.update(this.produto).subscribe(response => this.msg = "Alteração realizada com sucesso!");
  }
}
