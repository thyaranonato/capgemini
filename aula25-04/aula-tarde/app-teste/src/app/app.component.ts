import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Meu primeiro componente em Angular';
  nome: string = "Thyara";

  cliente = {
    id: 10,
    nome: "José da Silva"
  }

  trocar() {
    this.nome = "Ana";
  }
}

