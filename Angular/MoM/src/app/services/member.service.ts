import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  constructor(public httpClient: HttpClient) { }

  getOrgMembers(orgId: any) {
    return this.httpClient.get("member/byOrgId/" + orgId);

  }

  deleteMember(member: any) {
    return this.httpClient.get("deleteMember/" + member.memberId).pipe(delay(1000)).toPromise();

  }

  saveMember(member: any) {
    return this.httpClient.post("memberForm/save", member);
  }


}
