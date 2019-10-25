import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, map } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpResponse, HttpErrorResponse, HttpParams } from '@angular/common/http';

import { Product } from '../_models/product-model';
import { CartDetails } from '../_models/cart-detail-model';
import { shopperOrderId } from '../_models/shopper_order_id';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient ) { }
  baseUrl: string = 'http://localhost:8000/api/';

  userId=1;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

   // Handle API errors
   handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };

  public getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>('http://localhost:8000/api/products').pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

  public getCartDetails() {
    const params = new HttpParams().set('params', String(this.userId));
    return this.http.get<CartDetails>('http://localhost:8000/api/showCart', {params}).pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

  public shopperOrder() {
    const params = new HttpParams().set('params', String(this.userId));
    return this.http.get<shopperOrderId>('http://localhost:8000/api/shopperOrder', {params}).pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

  public shopperOrderId() {
    const params = new HttpParams().set('params', String(this.userId));
    return this.http.get<shopperOrderId>('http://localhost:8000/api/shopperOrderId', {params}).pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

  public insertCart(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:8000/api/addCart', cart,  { responseType: 'text' })
   .pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

  public updateCart(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:8000/api/updateCart', cart,  { responseType: 'text' })
   .pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

  public insertShopperOrder(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:8000/api/insertShopperOrder', cart,  { responseType: 'text' })
   .pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

  public insertOrderDetails(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:8000/api/insertOrderDetails', cart,  { responseType: 'text' })
   .pipe(
      retry(2),
      catchError(this.handleError)
    )
  }

}
