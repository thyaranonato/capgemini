import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-message-error',
  templateUrl: './message-error.component.html',
  styleUrls: ['./message-error.component.css']
})
export class MessageErrorComponent implements OnInit {
  msg: string = "Para realizar esta operação é necessário ser Administrador!";
  constructor() { }

  ngOnInit(): void {
  }

}
