import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RecentsComponent } from './recents/recents.component';
import {NonWrapsPipe} from "./recents/NonWrapsPipe";
import {WrapsPipe} from "./recents/WrapsPipe";
import { LittleButtonComponent } from './little-button/little-button.component';
import { DesignComponent } from './design/design.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    RecentsComponent,
    NonWrapsPipe,
    WrapsPipe,
    LittleButtonComponent,
    DesignComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
