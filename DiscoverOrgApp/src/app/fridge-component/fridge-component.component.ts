import { Component, OnInit } from '@angular/core';

import { FridgeService } from '../fridge-service/fridge.service';

@Component({
  selector: 'app-fridge-component',
  templateUrl: './fridge-component.component.html',
  styleUrls: ['./fridge-component.component.scss']
})
export class FridgeComponent implements OnInit {

  itemArray;
  itemUUIDCount = 1;
  item = {
    itemType: 'Drink',
    itemUUID: 1,
    name: 'Milk',
    fillFactor: 1
  };

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
      console.log(rtn['_body']);
      this.itemArray = rtn;
      console.log(this.itemArray);
    });
  }

  putItem() {
    console.log('put item!');
    this.fridgeService.putItems(this.item).then( rtn => {
      console.log('items put');
      console.log(rtn);
    });
  }

  

}
