import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  getAll() {
    let url = "http://localhost:3000/usuarios";
    return this.http.get(url);
  }
}
