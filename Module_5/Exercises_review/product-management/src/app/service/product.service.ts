import {Injectable} from '@angular/core';
import {Product} from '../model/Product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  private API_URL_PRODUCT: string = 'http://localhost:3000/listProduct';
  private API_URL_ORIGIN: string = 'http://localhost:3000/listOrigin';

  constructor(private _httpClient: HttpClient) {
  }

  private message: string = '';

  getListOrigin(): Observable<string[]> {
    return this._httpClient.get<string[]>(this.API_URL_ORIGIN);
  }

  getListProduct(): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL_PRODUCT);
  }

  save(product: Product): Observable<Product> {
    console.log("Product : "+product)
    return this._httpClient.post<Product>(this.API_URL_PRODUCT, product);
  }

  getProductById(id:number): Observable<Product> {
    return this._httpClient.get<Product>(`${this.API_URL_PRODUCT}/${id}`);
  }

  updateProductById(product: Product, id:number): Observable<Product> {
    return this._httpClient.put<Product>(`${this.API_URL_PRODUCT}/${id}`, product);
  }

  deleteProductById(id:number): Observable<Product> {
    return this._httpClient.delete<Product>(`${this.API_URL_PRODUCT}/${id}`);
  }

  getMessage(): string {
    return this.message;
  }
}
