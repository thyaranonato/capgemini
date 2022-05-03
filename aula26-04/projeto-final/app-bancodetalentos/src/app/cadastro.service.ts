import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  constructor(private http: HttpClient) { }

  create(data: any) {
    let url = 'http://localhost:8080/talentos';
    return this.http.post(url, data);
  }

  getAll() {
    let url = 'http://localhost:8080/talentos';
    return this.http.get(url);
  }

  getOne(idtalento: number) {
    return this.http.get(`http://localhost:8080/talentos/${idtalento}`)
  }

  alterar(dados: any) {
    let url = `http://localhost:8080/talentos/${dados.id}`
    return this.http.put(url, dados)
  }

  apagar(idtalento: number) {
    return this.http.delete(`http://localhost:8080/talentos/${idtalento}`)
  }
}
