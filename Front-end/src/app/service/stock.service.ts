import { Injectable } from '@angular/core';
import { HttpParams} from '@angular/common/http';
import { endPoints } from '../dto/constant';
import { HttpService } from './http.service';
import { NameCodePair } from '../entity/name-code-pair';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private httpService : HttpService) { }

  getPrice(params:HttpParams,header: NameCodePair[]){
    const endPoint = endPoints.stock;
    return this.httpService.get(endPoint,params,header);
  }

}
