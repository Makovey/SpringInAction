import { Component, OnInit, Injectable, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router/';
import { CartService } from '../cart/cart-service';

@Component({
  selector: 'app-design',
  templateUrl: './design.component.html',
  styleUrls: ['./design.component.less']
})
export class DesignComponent implements OnInit {

  model = {
    name: '',
    ingredients: []
  };

  constructor(private httpClient: HttpClient, private router: Router, private cart: CartService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.httpClient.post(
      'http://localhsot:8080/design',
      this.model, {
        headers: new HttpHeaders().set('Content-type', 'application/json'),
      }).subscribe(taco => this.cart.addToCart(taco));
    this.router.navigate(['/cart']);
  }

}
