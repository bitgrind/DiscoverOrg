import { Component, OnInit } from '@angular/core';

import { FridgeService } from '../fridge-service/fridge.service';

@Component({
  selector: 'app-fridge-component',
  templateUrl: './fridge-component.component.html',
  styleUrls: ['./fridge-component.component.scss']
})
export class FridgeComponent implements OnInit {

  itemArray;

  constructor(
    public fridgeService: FridgeService
  ) { }

  ngOnInit() {
  }

  getItems() {
    console.log('get items!');
    this.fridgeService.getItems().then( rtn => {
      console.log('items returned');
      console.log(rtn);
        this.itemArray = rtn;
    });
  }

}
