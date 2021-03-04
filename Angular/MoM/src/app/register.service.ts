import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';;
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(public httpClient:HttpClient) { }

  registerOrg(registrationForm: any){
    this.httpClient.post("register",registrationForm).pipe(delay(1000)).toPromise() ;

  }
}
