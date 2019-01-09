import { Component, OnInit } from '@angular/core';

import { FridgeService } from '../fridge-service/fridge.service';
import {FormControl, FormGroup} from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-fridge-component',
  templateUrl: './fridge-component.component.html',
  styleUrls: ['./fridge-component.component.scss']
})
export class FridgeComponent implements OnInit {

  itemArray;
  itemUUIDCount = 1;

  // @ts-ignore
  item = {
    itemType: 1,
    itemUUID: '1',
    itemName: 'Milk',
    fillFactor: 1.0
  };

  makeFridgeItemForm;

  constructor(
    public fridgeService: FridgeService
  ) {
    this.makeFridgeItemForm = new FormGroup({
      itemName: new FormControl(''),
      itemUUID: new FormControl(''),
      itemType: new FormControl(''),
      fillFactor: new FormControl(''),
    });
  }

  ngOnInit() {
  }

  getItems() {
    console.log('get items!');
    this.fridgeService.getItems().then( rtn => {
      console.log(rtn);
      this.itemArray = rtn;
    });
  }

  addItem(form) {

    const newItem = {
      itemName: form.value.itemName,
      itemUUID: form.value.itemUUID,
      itemType: form.value.itemType,
      fillFactor: form.value.fillFactor
    };

    console.log('add item!');
    console.log(newItem);
    this.fridgeService.addItems(newItem).then( rtn => {
      console.log(rtn);
    });
  }

  removeItem(item) {
    console.log('remove item');
    console.log(item);
    this.fridgeService.removeItem(item.itemUUID).then( rtn => {
      console.log(rtn);
    });
  }
}
