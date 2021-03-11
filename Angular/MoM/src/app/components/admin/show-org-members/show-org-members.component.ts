import { Component, OnInit } from '@angular/core';
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

  organization: any;

  constructor(public organizationService: OrganizationService, public userService: UserService, public memberService: MemberService) {
    this.editFlag = false;
    this.createFlag = false;



    this.editMember = {
      name: '', organisation: '', mailId: '', mobileNo: '', role: '', address: '', gender: '', loginId: '', password: ''
    };


  }

  async ngOnInit() {
    this.organization = await this.organizationService.getOrganizationByName(this.userService.user.organizationName).toPromise();
    console.log("Organization Details are " + JSON.stringify(this.organization));
    this.memberService.getOrgMembers(this.organization.id).subscribe((data: any) => { console.log(data), this.members = data });
  }



  showEditPop(member: any): void {
    this.editMember = member;
    this.editFlag = true;
    this.createFlag = false;
    jQuery('#empModel').modal('show');
  }

  deleteMember(member: any) {

  }
  updateMembers() {

    this.memberService.getOrgMembers(this.organization.id).subscribe((data: any) => { console.log(data), this.members = data });
  }

  updateMember(member: any) {
    console.log(member);
    this.memberService.saveMember(member);
  }

  newMember() {
    if (this.editFlag === true) {
      this.editMember = {
        name: '', organisation: '', mailId: '', mobileNo: '', role: '', address: '', gender: '', loginId: '', password: ''
      };
      this.editFlag = false;
    }
    this.createFlag = true;
    jQuery('#empModel').modal('show');

  }

}