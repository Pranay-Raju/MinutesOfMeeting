import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';;
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
/**
 * Service to do registration of new Organization
 */
export class RegisterService {

  constructor(public httpClient: HttpClient) { }

  registerOrg(registrationForm: any) {
    return this.httpClient.post("register", registrationForm).pipe(delay(1000)).toPromise();

  }
}
