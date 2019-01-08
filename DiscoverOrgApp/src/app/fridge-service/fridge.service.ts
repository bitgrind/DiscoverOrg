import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class FridgeService {

  getItemsUrl = 'http://localhost:8080/getItemsInFridge';
  putItemUrl = 'http://localhost:8080/addItem';

  constructor(
    private http: Http
  ) { }

  getItems() {
    return new Promise((resolve, reject) => {
      this.http.get(this.getItemsUrl)
        .map((res: Response) => res.json())
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

  putItems(item) {
    return new Promise((resolve, reject) => {
      this.http.put(this.putItemUrl, item)
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

}
