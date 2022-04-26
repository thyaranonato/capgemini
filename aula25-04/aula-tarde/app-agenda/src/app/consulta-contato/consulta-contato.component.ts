import { Component } from '@angular/core';

@Component({
  selector: 'app-consulta-contato',
  templateUrl: './consulta-contato.component.html',
  styleUrls: ['./consulta-contato.component.css']
})
export class ConsultaContatoComponent {

  constructor() { }

  load() {
    fetch("http://localhost:3000/contatos")
        .then(x => x.text())
        .then(dados => this.display(dados));
  }

  display(lista: string) {
    let dados = JSON.parse(lista);
    let trs = "";
    for(let obj in dados) {
        trs += "<tr>"
        trs += "<td>" + dados[obj].nome + "</td>"
        trs += "<td>" + dados[obj].fone + "</td>"
        trs += "<td>" + dados[obj].email + "</td>"
        trs += "</tr>"
    }
    document.getElementsByTagName("tbody")[0].innerHTML = trs;
  }

}
