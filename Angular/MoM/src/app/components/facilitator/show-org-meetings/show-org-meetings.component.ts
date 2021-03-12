import { Component, OnInit } from '@angular/core';

declare var jQuery: any;

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
      { meetingId: 1, name: 'Project', facilitator: 'harsha', startDateAndTime: '12Feb 8:00Am', endDateAndTime: '12Feb 9:00Am' },
      { meetingId: 2, name: 'Navya', facilitator: 'pasha', startDateAndTime: '12Feb 9:00Am', endDateAndTime: '12Feb 10:00Am' },
      { meetingId: 3, name: 'lavanya', facilitator: 'pranay', startDateAndTime: '13Feb 8:00Am', endDateAndTime: '13Feb 9:00Am' },
      { meetingId: 4, name: 'Tejaswini', facilitator: 'harsha', startDateAndTime: '14Feb 8:00Am', endDateAndTime: '14Feb 9:00Am' },
      { meetingId: 5, name: 'Rakesh', facilitator: 'rakesh', startDateAndTime: '15Feb 8:00Am', endDateAndTime: '15Feb 9:00Am' },
      { meetingId: 6, name: 'pranay', facilitator: 'harsha', startDateAndTime: '16Feb 8:00Am', endDateAndTime: '16Feb 9:00Am' }
    ]
    this.editMeeting = { meetingId: '', name: '', facilitator: '', startDateAndTime: '', endDateAndTime: '' };

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
  newMeeting() {
    this.createFlag = true;
    this.editFlag = false;
    jQuery('#empModel').modal('show');
  }

}