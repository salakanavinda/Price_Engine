import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { URL_SEPARATOR } from '../dto/constant';
import { NameCodePair } from '../entity/name-code-pair';
import {catchError, map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private serviceUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    params: new HttpParams({}),
  };
  
  constructor(private httpClient: HttpClient) { 
    this.serviceUrl = 'http://localhost:8080';
  }

  get(endPoint: string, urlParams?: string | any, header?: NameCodePair[]): Observable<any> {
    this.resetHeader();
    const url = this.serviceUrl.concat(URL_SEPARATOR).concat(endPoint);
    if (urlParams) {
      this.httpOptions.params = new HttpParams({
        fromObject: urlParams
      });
    }
    if (header) {
      const headerList: NameCodePair[] = header;
      if (headerList.length > 0) {
        headerList.forEach((value: NameCodePair) => {
          this.httpOptions.headers = this.httpOptions.headers.append(value.code, value.name);
        });
      }
    }
    return this.httpClient.get<any>(url, this.httpOptions)
      .pipe(map((res: any) => {
        return res;
      }), catchError((err) => {
        this.logError(err);
        return of(err);
      }));
  }


  private resetHeader() {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      params: new HttpParams({}),
    };
  }

  logError(err: any) {
    console.error(err);
  }
}
