import { Injectable } from '@angular/core';
import jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class DecodeTokenService {

  public decodeTokenJWT(): string {
    try {
      let token = localStorage.getItem('token') || "";
    return jwt_decode(token);
    } catch(error) {
      return "";
    }
  }
}
