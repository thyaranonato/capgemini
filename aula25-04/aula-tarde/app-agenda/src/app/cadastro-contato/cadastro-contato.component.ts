import { Component } from '@angular/core';
import { ServiceContatoService } from '../service-contato.service';

@Component({
  selector: 'app-cadastro-contato',
  templateUrl: './cadastro-contato.component.html',
  styleUrls: ['./cadastro-contato.component.css']
})
export class CadastroContatoComponent {
  msg: string = "";
  constructor(private serviceContato: ServiceContatoService) { }

  saveContato(data: any) {
    // data.id = this.contatos.length +1;
    // this.contatos.push(data);
    this.serviceContato.save(data).subscribe(x => this.msg = "Contato salvo com sucesso!");
  }

}
