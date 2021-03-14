import { Component, OnInit } from '@angular/core';
import { SubHeadingService } from 'src/app/services/meeting&minutes/sub-heading.service';

@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.css']
})
export class PointComponent implements OnInit {

  constructor(public subHeadService:SubHeadingService) { }

  ngOnInit(): void {
  }

}
