import { Component, OnInit } from '@angular/core';

import { ApiService } from '../core/api.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  userId=1;
  itemList: any = [];
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data
    });
  }

}
