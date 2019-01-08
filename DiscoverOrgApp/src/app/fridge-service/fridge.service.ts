import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class FridgeService {

  getItemsUrl = 'http://localhost:8080/getItems';

  constructor(
    private http: Http
  ) { }

  getItems() {
    return new Promise((resolve, reject) => {
      this.http.get(this.getItemsUrl)
        .subscribe( data => {
          resolve(data);
          reject(data);
        });
    });
  }

}
