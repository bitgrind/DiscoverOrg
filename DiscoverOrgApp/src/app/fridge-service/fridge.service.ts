import { Injectable } from '@angular/core';
import {HttpModule, RequestOptions, Response} from '@angular/http';
import 'rxjs/Rx';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class FridgeService {

  getItemsUrl = 'http://localhost:8080/getItemsInFridge';
  putItemUrl = 'http://localhost:8080/addItem';
  removeItemUrl = 'http://localhost:8080/removeItem';

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
      this.http.post(this.putItemUrl, item)
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

  removeItem(item) {
    return new Promise((resolve, reject) => {
      this.http.get(this.removeItemUrl + '?itemUUID=' + item)
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

}
