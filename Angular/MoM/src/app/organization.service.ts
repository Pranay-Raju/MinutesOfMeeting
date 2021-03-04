import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(public httpClient:HttpClient) { }

  public getAllOrganizations(){
    return this.httpClient.get('allOrganizations');
  }
}
