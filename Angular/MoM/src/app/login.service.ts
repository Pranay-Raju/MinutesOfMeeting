import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  user: any;

  constructor(public httpClient:HttpClient) { 
    this.user = {name: "XYZ"};
  }

  public loginAsUser(userCred: any):Observable<any> {
    return this.httpClient.post("/userWithCredentials",userCred)
  }
}
