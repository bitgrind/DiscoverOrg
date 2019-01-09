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

  shoppingList;
  averageFillItem;
  averageFillAmount;

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
    this.getItems();
  }

  getItems() {
    console.log('get items!');
    this.fridgeService.getItems().then( rtn => {
      console.log(rtn);
      this.itemArray = rtn;
    });
  }

  addItem(form) {
    console.log('submit form');
    console.log(form);

    const newItem = {
      itemName: form.controls['itemName'].value,
      itemUUID: form.controls['itemUUID'].value,
      itemType: form.controls['itemType'].value,
      fillFactor: form.controls['fillFactor'].value
    };

    console.log('add item!');
    console.log(newItem);
    this.fridgeService.addItems(newItem).then( rtn => {
      console.log(rtn);
      this.getItems();
    });
  }

  removeItem(item) {
    console.log('remove item');
    console.log(item);
    this.fridgeService.removeItem(item.itemUUID).then( rtn => {
      console.log(rtn);
      this.getItems();
    });
  }

  forgetItem(item) {
    console.log('forget item');
    console.log(item);
    this.fridgeService.forgetItem(item.itemUUID).then( rtn => {
      console.log(rtn);
      this.getItems();
    });
  }

  getAverageFill(item) {
    console.log('forget item');
    console.log(item);
    this.averageFillItem = item;
    this.fridgeService.getAverageFill(item.itemType).then( rtn => {
      console.log(rtn);
      this.averageFillAmount = rtn;
    });
  }

  getShoppingList() {
    this.fridgeService.getShoppingItems(.5).then( rtn => {
      console.log(rtn);
      this.shoppingList = rtn;
    });
  }
}
