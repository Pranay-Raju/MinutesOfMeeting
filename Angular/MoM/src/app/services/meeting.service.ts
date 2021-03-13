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
    this.httpClient.post("meetingForm/save", meeting);
  }

  getMeetings(id: number) {
    return this.httpClient.get("meeting/byOrgId/" + id);
  }

  getFacilitators() {
    return this.facilitators;
  }

  setFacilitators(facilitators: any) {
    this.facilitators = facilitators;
  }


}
