import { CadastroService } from './../cadastro.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  constructor(private route: ActivatedRoute, private cadastroService: CadastroService) { }
  talento: any = {}
  msg: string = ''

  ngOnInit(): void {
    let routeParams = this.route.snapshot.paramMap;
    let idtalento:number = Number(routeParams.get('idtalento'))
    this.cadastroService.getOne(idtalento).subscribe(x => this.talento = x)
  }

  visible: boolean = true;
  changetype: boolean = true;

  viewPassword() {
    this.visible = !this.visible;
    this.changetype = !this.changetype;
  }

  editar() {
    this.cadastroService.alterar(this.talento).subscribe(x => {window.location.reload()})
  }

  excluir(id: any) {
    this.cadastroService.apagar(id).subscribe(x => {window.location.reload()});
  }
}
