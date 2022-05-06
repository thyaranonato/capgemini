import { DecodeTokenService } from './decode-token.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService implements CanActivate {

  constructor(private decodeToken: DecodeTokenService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | boolean {
    if(!this.usuarioLogado()) {
      this.router.navigate(['/login']);
    }
    return true;
  }

  usuarioLogado(): boolean {
    let token = this.decodeToken.decodeTokenJWT();
    console.log(token)
    return token != "";
  }
}
