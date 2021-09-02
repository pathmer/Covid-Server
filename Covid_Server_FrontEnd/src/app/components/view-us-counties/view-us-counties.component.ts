import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { UsCountiesService } from '../../services/us-counties.service';
import { US_County } from '../../interfaces/US_County';

@Component({
  selector: 'app-view-us-counties',
  templateUrl: './view-us-counties.component.html',
  styleUrls: ['./view-us-counties.component.css']
})
export class ViewUsCountiesComponent implements OnInit {

  uscounties: US_County[] = [];

  constructor(
    private route: ActivatedRoute,
    private UsCountiesService: UsCountiesService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getUS_Counties();
  }

  getUS_Counties(): void {
    this.UsCountiesService.getAllUS_County().subscribe(uscounties => {
      this.uscounties = uscounties;
      return this.uscounties;
      uscounties.sort((a, b) => {
        if (a.id != undefined && b.id != undefined) {
          return a.id - b.id;
        }
        return 0;
      });
    })
  }


  goBack(): void {
    this.location.back();
  }

}
