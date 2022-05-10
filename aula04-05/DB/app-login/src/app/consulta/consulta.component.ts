import { Component } from '@angular/core';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent{
  listaClientes: any = [];

  constructor(private clienteService: ClienteService) {
    this.getAll();
  }

  getAll() {
    this.clienteService.getAll().subscribe(response => { this.listaClientes = response});
    console.log(this.listaClientes);
  }

}
