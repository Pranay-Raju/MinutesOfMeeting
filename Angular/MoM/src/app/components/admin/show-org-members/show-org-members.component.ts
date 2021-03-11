import { Component, OnInit } from '@angular/core';
import { delay } from 'rxjs/operators';
import { MemberService } from 'src/app/services/member.service';
import { UserService } from 'src/app/services/user.service';
import { OrganizationService } from '../../../services/organization.service';

declare var jQuery: any;

@Component({
  selector: 'app-show-org-members',
  templateUrl: './show-org-members.component.html',
  styleUrls: ['./show-org-members.component.css']
})
export class ShowOrgMembersComponent implements OnInit {

  members: any;

  editMember: any;
  editFlag: boolean;
  createFlag: boolean;

  constructor(public organizationService: OrganizationService, public userService: UserService, public memberService: MemberService) {
    this.editFlag = false;
    this.createFlag = false;



    this.editMember = {
      name: '', organisation: '', mailId: '', mobileNo: '', role: '', address: '', gender: '', loginId: '', password: ''
    };


  }

  async ngOnInit() {
    console.log("Organization Details are " + JSON.stringify(this.organizationService.organizationDetails));
    this.memberService.getOrgMembers(this.organizationService.organizationDetails.organizationId).subscribe((data: any) => { console.log(data), this.members = data });
  }



  showEditPop(member: any): void {
    this.editMember = member;
    this.editFlag = true;
    this.createFlag = false;
    jQuery('#empModel').modal('show');
  }

  deleteMember(member: any) {
    this.memberService.getOrgMembers(this.organizationService.organizationDetails.organizationId).subscribe((data: any) => { console.log(data), this.members = data });
    this.memberService.deleteMember(member);

  }
  updateMembers() {
    this.memberService.getOrgMembers(this.organizationService.organizationDetails.organizationId).subscribe((data: any) => { console.log(data), this.members = data });
  }

  async updateMember(member: any) {
    
    member.organization = this.organizationService.organizationDetails;
    console.log(member);
    const a =await this.memberService.saveMember(member).pipe(delay(1000)).toPromise();
    console.log("Response is " +a);
  }

  newMember() {
    if (this.editFlag === true) {
      this.editMember = {
        name: '', organisation: this.organizationService.organizationDetails.organizationName, mailId: '', mobileNo: '', role: '', address: '', gender: '', loginId: '', password: ''
      };
      this.editFlag = false;
    }
    this.createFlag = true;
    jQuery('#empModel').modal('show');
  }

}