import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-bancodetalentos';

  userLogado: any = {}

  usuarioConectado() {
    let user: (string | null) = localStorage.getItem("userConectado")
    if (user != null) {
      user = JSON.parse(user)
      this.userLogado = user
    }
    console.log(this.userLogado)
  }

  constructor() {
    this.usuarioConectado()
  }

  logOut() {
    localStorage.removeItem("userConectado")
    window.location.href = 'login'
  }
}


