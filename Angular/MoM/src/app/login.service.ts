import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(public httpClient:HttpClient) { }

  /**
   * loginAsUser
userCred: any   */
  public loginAsUser(userCred: any):Observable<any> {
    return this.httpClient.post("userWithCredentials",userCred);
  }
}
