import { Injectable } from '@angular/core';
import {Customer} from "../model/Customer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private API_URL_CUSTOMER:string = "http://localhost:3000/listCustomer";
  private API_URL_TYPE:string = "http://localhost:3000/listTypeCustomer";

  constructor(private httpClient:HttpClient) { }

  getListCustomer():Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.API_URL_CUSTOMER);
  }

  getListType():Observable<string[]>{
    return this.httpClient.get<string[]>(this.API_URL_TYPE);
  }

  save(customer:Customer):Observable<Customer>{
    return this.httpClient.post<Customer>(this.API_URL_CUSTOMER, customer);
  }

  getCustomerById(id:number):Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.API_URL_CUSTOMER}/${id}`);
  }

  updateCustomerById(customer: Customer, id:number): Observable<Customer> {
    return this.httpClient.put<Customer>(`${this.API_URL_CUSTOMER}/${id}`, customer);
  }

  deleteCustomerById(id:number): Observable<Customer> {
    return this.httpClient.delete<Customer>(`${this.API_URL_CUSTOMER}/${id}`);
  }

  searchFull(fullSearch: string):Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL_CUSTOMER+"?q="+fullSearch);
  }
}
