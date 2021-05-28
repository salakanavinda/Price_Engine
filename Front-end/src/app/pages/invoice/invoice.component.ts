import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NameCodePair } from 'src/app/entity/name-code-pair';
import { Product } from 'src/app/entity/product';
import { ProductService } from 'src/app/service/product.service';
import { StockService } from 'src/app/service/stock.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  productList : Product[] = [];
  price : any;

  productId:number = 0;
  qty:number = 0;
  isCarton :boolean = false;

  public qtyForm: FormGroup;
  
  constructor(private stockService : StockService,private productService : ProductService) { 
    this.qtyForm = new FormGroup({
      qty: new FormControl('', [Validators.required])
    });
  }

  ngOnInit(): void {
    this.getProducts();
  }

  onProductSelect(event: any){
      this.productId = event.target.value;
      console.log(this.productId);
  }

  getPrice(productId:number,qty:number,isCarton:boolean){

    const header: NameCodePair[] = [
    ];

    const params = new HttpParams()
    .set('product_id', productId)
    .set('qty', qty)
    .set('is_carton', isCarton);

     this.price = this.stockService.getPrice(params,header);
  }

  getProducts(){
    this.productList = [{id:1,name:"ssss"}];
  }

  onQty() {
  }

  onEnterQty(event:any){
    this.qty = event.traget.value;
    console.log(this.qty);
  }

  onCartonSelect(event: any){
    console.log(event);
  }

}
