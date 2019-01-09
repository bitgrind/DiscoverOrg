import { Injectable } from '@angular/core';
import {HttpModule, RequestOptions, Response} from '@angular/http';
import 'rxjs/Rx';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class FridgeService {

  getItemsUrl = 'http://localhost:8080/getItemsInFridge';
  putItemUrl = 'http://localhost:8080/addItem';
  removeItemUrl = 'http://localhost:8080/removeItem';
  forgetItemUrl = 'http://localhost:8080/forgetItem';
  getShoppingItemsUrl = 'http://localhost:8080/getItems';


  constructor(
    private http: HttpClient
  ) { }

  getItems() {
    return new Promise((resolve, reject) => {
      this.http.get(this.getItemsUrl)
        // .map((res: Response) => res.json())
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

  addItems(item) {
    return new Promise((resolve, reject) => {
      this.http.post(this.putItemUrl, item, {responseType: 'text'})
        .subscribe( data => {
          console.log(data);
          resolve(data);
          reject(data);
        });
    });
  }

  removeItem(item) {
    return new Promise((resolve, reject) => {
      this.http.get(this.removeItemUrl + '?itemUUID=' + item, {responseType: 'text'})
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

  forgetItem(item) {
    return new Promise((resolve, reject) => {
      this.http.get(this.forgetItemUrl + '?itemUUID=' + item, {responseType: 'text'})
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

  getShoppingItems(number) {
    return new Promise((resolve, reject) => {
      this.http.get(this.getShoppingItemsUrl + '?fillFactor=' + number)
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

}
