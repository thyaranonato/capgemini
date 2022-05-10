import { Component } from '@angular/core';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent{

  constructor(private clienteService: ClienteService) {
    this.getAll();
  }

  getAll() {
    this.clienteService.getAll().subscribe(response => console.log(response));
  }

}
