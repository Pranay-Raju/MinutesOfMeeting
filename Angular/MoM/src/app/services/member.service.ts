import {  HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  constructor(public httpClient: HttpClient) { }

  getOrgMembers(orgId:any){
    return this.httpClient.get("member/byOrgId/" + orgId);

  }

saveMember(member:any){
  return this.httpClient.post("memberForm/save",member);
}


}
