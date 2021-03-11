import { Component, OnInit } from '@angular/core';

declare var jQuery:any;

@Component({
  selector: 'app-show-org-meetings',
  templateUrl: './show-org-meetings.component.html',
  styleUrls: ['./show-org-meetings.component.css']
})
export class ShowOrgMeetingsComponent implements OnInit {
  meetings: any
  editMeeting: any;
  editFlag: boolean;
  createFlag: boolean;

  constructor() {
    this.editFlag = false;
    this.createFlag = false;
    this.meetings = [
      { meetingId: 1, name: 'Gayathri' },
      { meetingId: 2, name: 'Navya' },
      { meetingId: 3, name: 'lavanya' },
      { meetingId: 4, name: 'Tejaswini' },
      { meetingId: 5, name: 'Rakesh' },
      { meetingId: 6, name: 'pranay' }
    ]
    this.editMeeting = { meetingId: 1, name: 'Gayathri' };

  }

  ngOnInit(): void {
  }
  ShowEditPopup(meeting: any) {
this.editMeeting = meeting;
this.editFlag = true;
this.createFlag = false;
    jQuery('#empModel').modal('show');
  }
  deleteMeeting(meeting: any) {

  }
  updateMeeting(meeting: any) {

  }
  newMeeting(){
this.createFlag=true;
this.editFlag = false;
    jQuery('#empModel').modal('show');
  }

}