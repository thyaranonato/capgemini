import { Component } from '@angular/core';
import { CadastroService } from '../cadastro.service';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent {
  talentos: any

  constructor(private serviceCadastro: CadastroService) {
    this.serviceCadastro.getAll().subscribe(response => this.talentos = response)
  }
}
