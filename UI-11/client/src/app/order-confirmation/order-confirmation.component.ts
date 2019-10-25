import { Component, OnInit } from '@angular/core';

import { ApiService } from '../core/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-confirmation',
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent implements OnInit {

  itemList: any = [];
  orderId: any = [];
  totalQuantity = 0;
  totalPrice = 0;
  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {

    this.loadData();
  }

  loadData() {

    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data;
      for (var itemCount = 0; itemCount < this.itemList.length; itemCount++) {
        this.totalQuantity += this.itemList[itemCount].quantity;
        this.totalPrice += this.itemList[itemCount].quantity * this.itemList[itemCount].price;
      }
    });
  }

  async placeOrder() {
    this.insertShopperOrder();

    await new Promise(resolve => {
      setTimeout(() => {

        this.apiService.shopperOrderId().subscribe(async data => {
          this.orderId = data;

          await new Promise(resolve => {
            setTimeout(() => {
              // console.log("orderId: ",this.orderId[0].id);
              this.insertOrderDetails(this.orderId[0].id);
              resolve();
            }, 5);
          });
        })
        resolve();
      }, 5);
    });
    this.router.navigate(['/order-received']);
  }

  insertShopperOrder() {
    console.log("insertInShopperOrder start;");
    let j: any = [];
    let order = '{"totalAmount":' + this.totalPrice + ', "status":"confirm", "userId":1}';
    j = JSON.parse(order);

    var msg: any;
    console.log("inserting:\n");
    this.apiService.insertShopperOrder(j).subscribe(data => {
      msg = data;
    })
    console.log(msg);
    return 1;
  }

  insertOrderDetails(orderId) {
    console.log("insertInShopperOrder start;");
    let cart;
    let j: any = [];
    console.log("OID insert OD", orderId.id);
    for (var i = 0; i < this.itemList.length; i++) {
      cart = '{"shopperOrderId":' + orderId + ', "productID":' + this.itemList[i].id + ', "quantity":' + this.itemList[i].quantity
        + ', "unitPrice":' + this.itemList[i].price + ',"status":"confirm" }';
      j.push(JSON.parse(cart));
    }
    var msg: any;
    console.log("inserting:\n");
    this.apiService.insertOrderDetails(j).subscribe(data => {
      msg = data;
    })
    console.log(msg);
    return 1;
  }
}
