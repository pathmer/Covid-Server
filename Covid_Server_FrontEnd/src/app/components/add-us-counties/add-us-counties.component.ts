import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { HttpClient } from "@angular/common/http";

import { UsCountiesService } from '../../services/us-counties.service';
import { US_County } from '../../interfaces/US_County';

@Component({
  selector: 'app-add-us-counties',
  templateUrl: './add-us-counties.component.html',
  styleUrls: ['./add-us-counties.component.css']
})
export class AddUsCountiesComponent implements OnInit {

  uscounties: US_County[] = [];
  fileName = '';

  constructor(
    private route: ActivatedRoute,
    private UsCountiesService: UsCountiesService,
    private location: Location,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
  }

  
  async onFileSelected(event: any) {
    var file: File = event.target.files[0];
    this.fileName = file.name;
    var reader = new FileReader();
    reader.readAsText(file);
    const this_ = this;
    reader.onload = function(event) {
      var csv = <string>event.target!.result;
      var rows = csv.split('\r\n');
      for (let i = 1; i < rows.length; i++) {
        var cols = rows[i].split(/,(?=(?:(?:[^"]*"){2})*[^"]*$)/);
        let uscounty: US_County = new US_County(
          parseInt( cols[0], 10),
          cols[1],
          cols[2],
          parseInt( cols[3].replace('\"', '').replace(',', '').replace(',', ''), 10));
          task();
          function task() {
            setTimeout(function() {
              this_.UsCountiesService.addUS_County(uscounty).subscribe(
                uscounties => {
                  console.log(uscounties);
                },
                error => {
                  console.log(error);
                }
              )
            }, i);
        }
      }
    }
  }


  goBack(): void {
    this.location.back();
  }

}

