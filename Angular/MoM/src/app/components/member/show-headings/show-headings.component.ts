import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-headings',
  templateUrl: './show-headings.component.html',
  styleUrls: ['./show-headings.component.css']
})
export class ShowHeadingsComponent implements OnInit {

  headings: any;
  cakes: any;
  dataList: any;

  meeting: any;

  constructor() {
    this.meeting = {
      "id": 1,
      "meetingName": "Project Meeting",
      "organizationName": "Talent Sprint",
      "facilitator": {
        "memberId": 4,
        "name": "Harsha",
        "organizationName": "Talent Sprint",
        "mobileNo": "9989225602",
        "role": "Trainer",
        "address": "SEC",
        "gender": "M",
        "loginId": "harsha123",
        "password": "pass"
      },
      "startDateAndTime": "2021-03-06T07:00:35.749+00:00",
      "endDateAndTime": "2021-03-06T07:00:35.749+00:00",
      "attendees": [
        {
          "memberId": 4,
          "name": "Harsha",
          "organizationName": "Talent Sprint",
          "mobileNo": "9989225602",
          "role": "Trainer",
          "address": "SEC",
          "gender": "M",
          "loginId": "harsha123",
          "password": "pass"
        },
        {
          "memberId": 5,
          "name": "Pasha",
          "organizationName": "Talent Sprint",
          "mobileNo": "9989225602",
          "role": "Manager",
          "address": "DEL",
          "gender": "M",
          "loginId": "pasha123",
          "password": "password"
        }
      ],
      "headings": [
        {
          "id": 1,
          "value": "Agenda",
          "parent_heading_id": 0,
          "subHeadings": [
            {
              "id": 2,
              "value": "Team Design",
              "parent_heading_id": 0,
              "subHeadings": [],
              "points": [
                {
                  "id": 1,
                  "info": "TEAM1 has Pranay"
                },
                {
                  "id": 2,
                  "info": "TEAM2 has Sandeep"
                }
              ]
            },
            {
              "id": 3,
              "value": "Project Design",
              "parent_heading_id": 0,
              "subHeadings": [],
              "points": [
                {
                  "id": 3,
                  "info": "TEAM1 has MoM"
                },
                {
                  "id": 4,
                  "info": "TEAM2 has ECommerce"
                }
              ]
            }
          ],
          "points": []
        },
        {
          "id": 1,
          "value": "Closing",
          "parent_heading_id": 0,
          "subHeadings": [
            {
              "id": 2,
              "value": "Team Design",
              "parent_heading_id": 0,
              "subHeadings": [],
              "points": [
                {
                  "id": 1,
                  "info": "TEAM1 has Pranay"
                },
                {
                  "id": 2,
                  "info": "TEAM2 has Sandeep"
                }
              ]
            },
            {
              "id": 3,
              "value": "Project Design",
              "parent_heading_id": 0,
              "subHeadings": [],
              "points": [
                {
                  "id": 3,
                  "info": "TEAM1 has MoM"
                },
                {
                  "id": 4,
                  "info": "TEAM2 has ECommerce"
                }
              ]
            }
          ],
          "points": []
        }
      ]
    }

    this.headings = [
      {
        "value": "Agenda",
        "subHeading": [
          {
            "value": "Project Plan"
          },
          {
            "value": "Team Plan"
          }
        ]
      },
      {
        "value": "Closing",
        "subHeading": [
          {
            "value": "Project Plan"
          },
          {
            "value": "Team Plan"
          }
        ]
      }
    ];

    this.cakes = [
      {
        "id": "0001",
        "type": "donut",
        "name": "Cake",
        "ppu": 0.56,
        "batters": {
          "batter": [
            { "id": "1001", "type": "Regular" },
            { "id": "1002", "type": "Chocolate" },
            { "id": "1003", "type": "Blueberry" },
            { "id": "1004", "type": "Devil’s Food" }]
        },
        "topping": [
          { "id": "5001", "type": "None" },
          { "id": "5002", "type": "Glazed" },
          { "id": "5005", "type": "Sugar" },
          { "id": "5007", "type": "Powdered Sugar" },
          { "id": "5006", "type": "Chocolate with Sprinkles" },
          { "id": "5003", "type": "Chocolate" },
          { "id": "5004", "type": "Maple" }]
      },
      {
        "id": "0002",
        "type": "donut",
        "name": "Raised",
        "ppu": 0.12,
        "batters": {
          "batter": [
            { "id": "1001", "type": "Strawberry" }]
        },
        "topping": [
          { "id": "5001", "type": "Vanilla" },
          { "id": "5002", "type": "Mango" },
          { "id": "5005", "type": "Cherry" },
          { "id": "5003", "type": "Chocolate" },
          { "id": "5004", "type": "Butterscotch" }]
      },
      {
        "id": "0003",
        "type": "donut",
        "name": "Old Fashioned",
        "ppu": 0.34,
        "batters": {
          "batter": [
            { "id": "1001", "type": "Regular" },
            { "id": "1002", "type": "Vanilla" }
          ]
        },
        "topping": [
          { "id": "5001", "type": "None" },
          { "id": "5002", "type": "Chocolate Chips" },
          { "id": "5003", "type": "Black Currant" },
          { "id": "5004", "type": "Pista" }
        ]
      }
    ]


    this.dataList = [
      {
        'Employee': {
          'Name': {
            'First': 'Roy',
            'Last': 'Agasthyan'
          },
          'Address': {
            'HouseNo': 100,
            'State': 'Kerala',
            'Country': 'India'
          }
        }
      },
      {
        'Employee': {
          'Name': {
            'First': 'Sam',
            'Last': 'Thomson'
          },
          'Address': {
            'HouseNo': 120,
            'State': 'Delhi',
            'Country': 'India'
          }
        }
      }
    ];
  }

  ngOnInit(): void {
  }

  getKeys(obj: any) {
    return Object.keys(obj)
  }

}
