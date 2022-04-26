import { Component } from '@angular/core';
import { CadastroService } from '../cadastro.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {
  msg: string = "";

  constructor(private serviceCadastro: CadastroService) { }

  createTalent(data: any) {
    this.serviceCadastro.create(data).subscribe(response => this.msg = "Talento cadastrado com sucesso!!");
  }
}
