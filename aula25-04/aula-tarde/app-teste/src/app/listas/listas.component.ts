import { Component } from '@angular/core';

@Component({
  selector: 'app-listas',
  templateUrl: './listas.component.html',
  styleUrls: ['./listas.component.css']
})
export class ListasComponent {
  frutas: string[] = [];
  constructor() {
    this.frutas.push("maça");
    this.frutas.push("banana");
    this.frutas.push("melancia");
    this.frutas.push("uva");
  }
}
