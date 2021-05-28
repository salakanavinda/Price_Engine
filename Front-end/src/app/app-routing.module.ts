import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InvoiceComponent } from './pages/invoice/invoice.component';
import { NavigationComponent } from './pages/navigation/navigation.component';
import { ProductsComponent } from './pages/products/products.component';

const routes: Routes = [
  {path: '', redirectTo: 'main', pathMatch: 'full'},
  {path: 'main', component: NavigationComponent, data: {title: 'Main'}},
  {path: 'invoice', component: InvoiceComponent , data: {title: 'Invoice'}},
  {path: 'product', component: ProductsComponent , data: {title: 'Product'}}
  // {path: '404', component: Error404Component, data: {title: 'Page 404'}},
  // {path: '500', component: Error500Component, data: {title: 'Page 500'}},
  // {path: '401', component: Error401Component, data: {title: 'Page 401'}},
  // {path: '**', component: Error404Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
