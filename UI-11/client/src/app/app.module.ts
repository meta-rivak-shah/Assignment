import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProductListComponent } from './product-list/product-list.component';
import { CartComponent } from './cart/cart.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { OrderReceivedComponent } from './order-received/order-received.component';
import { HomeComponent } from './home/home.component';

const appRoutes: Routes = [
  { path: 'cart/:userId', component: CartComponent },
  { path: 'home', component: HomeComponent },
  { path: 'nav-bar', component: NavBarComponent },
  { path: 'order-confirmation', component: OrderConfirmationComponent },
  { path: 'order-received', component: OrderReceivedComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'app-component', component: AppComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
  
];

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ProductListComponent,
    CartComponent,
    CategoryListComponent,
    OrdersComponent,
    OrderConfirmationComponent,
    OrderReceivedComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
