import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { ApiService } from '../core/api.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  itemList: any = [];
  totalQuantity = 0;
  totalPrice = 0;

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data;
      for (var i = 0; i < this.itemList.length; i++) {
        this.totalPrice += this.itemList[i].price * this.itemList[i].quantity;
        this.totalQuantity+=this.itemList[i].quantity;
      }
    });

  }

  reduceQuantity(id) {
    for (var i = 0; i < this.itemList.length; i++) {
      if (this.itemList[i].id == id) {
        this.itemList[i].quantity -= 1;
        this.totalPrice -= this.itemList[i].price;
        this.totalQuantity-=1;
      }
    }
  }

  increaseQuantity(id) {
    for (var i = 0; i < this.itemList.length; i++) {
      if (this.itemList[i].id == id) {
        this.itemList[i].quantity += 1;
        this.totalPrice += this.itemList[i].price;
        console.log(this.itemList[i].price);
        this.totalQuantity+=1;
      }
    }
  }

  async checkOut() {
    this.updateCart(); 
    await new Promise(resolve => {
      setTimeout(()=> { this.router.navigate(['/order-confirmation']); 
      resolve();
      }, 5);
    });
    
  }



  updateCart() {
    console.log("insertInCart start;");
    let cart;
    let j:any=[];
    for(var i = 0; i< this.itemList.length; i++){
    cart = '{"userId":1, "productId":' + this.itemList[i].id + ', "quantity":'+ this.itemList[i].quantity +'}';
    j.push(JSON.parse(cart)); 
    }
    var msg: any;
    console.log("inserting:\n");
    this.apiService.updateCart(j).subscribe(data => {
      msg = data;
    })
    console.log(msg);
    return 1;
}


}
