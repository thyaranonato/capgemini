import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }

  gravar(data: any) {
    let url = "http://localhost:8081/produtos";
    return this.http.post(url, data);
  }

  getAll() {
    let url = "http://localhost:8081/produtos";
    return this.http.get(url);
  }

  getOne(idProduto: number) {
    return this.http.get(`http://localhost:8081/produtos/${idProduto}`);
  }

  update(data: any) {
    let url = `http://localhost:8081/produtos/${data.id}`;
    return this.http.put(url, data);
  }

  delete(idProduto: number) {
    let url = `http://localhost:8081/produtos/${idProduto}`;
    return this.http.delete(url);
  }
}
