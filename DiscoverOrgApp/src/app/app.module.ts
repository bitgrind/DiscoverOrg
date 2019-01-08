import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { FridgeComponent } from './fridge-component/fridge-component.component';

import { FridgeService } from './fridge-service/fridge.service'

@NgModule({
  declarations: [
    AppComponent,
    FridgeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    FridgeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
