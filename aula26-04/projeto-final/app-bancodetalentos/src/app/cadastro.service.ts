import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  constructor(private http: HttpClient) { }

  create(data: any) {
    let url = "http://localhost:3000/talentos";
    return this.http.post(url, data);
  }

  getAll() {
    let url = "http://localhost:3000/talentos";
    return this.http.get(url);
  }
}
