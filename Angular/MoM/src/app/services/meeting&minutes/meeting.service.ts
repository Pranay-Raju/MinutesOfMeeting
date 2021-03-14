import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
/**
 * service to manage the meeting management related calls
 */
export class MeetingService {

  meeting: any;
  facilitators: any;

  constructor(public httpClient: HttpClient) {

  }

  createMeeting(meeting: any) {
    return this.httpClient.post("meetingForm/save", meeting);
  }

  updateMeeting(meeting: any) {
    return this.httpClient.post("meetingForm/update", meeting);
  }

  getMeetings(id: number) {
    return this.httpClient.get("meeting/byOrgId/" + id);
  }

  deleteMeeting(meeting:any){
    // this.httpClient.delete("meeting/",meeting);
    return this.httpClient.get("deleteMeeting/" + meeting.id);
  }

  getFacilitators() {
    return this.facilitators;
  }

  setFacilitators(facilitators: any) {
    this.facilitators = facilitators;
  }

}
