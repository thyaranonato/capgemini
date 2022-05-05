import { Component } from '@angular/core';
import { CadastroService } from '../cadastro.service';


@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {
  msg = ''

  constructor(private serviceCadastro: CadastroService) { }

  createTalent(data: any) {
    //data.perfil = "TALENTO"
    this.serviceCadastro.create(data).subscribe(response => setInterval(() => {window.location.href = 'login'}, 1000));
    this.msg = 'Talento cadastrado com sucesso!';
  }
}
