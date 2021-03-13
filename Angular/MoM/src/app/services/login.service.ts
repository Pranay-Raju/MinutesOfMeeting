import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
/**
 * Service to check if user is logged in or not
 */
export class LoginService {

  user: any;
  userLoggedIn: boolean;

  constructor(public httpClient: HttpClient) {
    this.user = { name: "XYZ" };
    this.userLoggedIn = false;
  }

  public loginAsUser(userCred: any): Observable<any> {
    return this.httpClient.post("/userWithCredentials", userCred)
  }



  getUserLoggedIn() {
    return this.userLoggedIn;
  }
  setUserLoggedIn(value: boolean) {
    this.userLoggedIn = value;
  }
}
