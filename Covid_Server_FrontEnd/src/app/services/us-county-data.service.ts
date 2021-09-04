import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { US_County_Data } from '../interfaces/US_County_Data';
// import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class UsCountyDataService {


  constructor(private http: HttpClient) { } // , private cookieService: CookieService

  url: string = 'http://localhost:8080/Covid_Server/US_County_Data';
  // url: string = `http://ec2-54-67-83-160.us-west-1.compute.amazonaws.com:8080/Project%202/workorders`;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }) // , 'Authorization': this.cookieService.get('auth')
  };

  getAllUS_County_Data(): Observable<US_County_Data[]> {
    return this.http.get<US_County_Data[]>(this.url, this.httpOptions).pipe(
      catchError(this.handleError<US_County_Data[]>(`getAllUS_County_Data`, []))
    );
  }

  getUS_County_Data(id: number): Observable<US_County_Data> {
    return this.http.get<US_County_Data>(this.url + '/' + id, this.httpOptions).pipe(
      catchError(this.handleError<US_County_Data>(`getUS_County_Data`, ))
    );
  }
  
  updateUS_County_Data(US_County_Data: US_County_Data): Observable<US_County_Data> {
    return this.http.put<US_County_Data>(this.url + '/update', US_County_Data, this.httpOptions).pipe(
      catchError(this.handleError<US_County_Data>(`updateUS_County_Data`))
    );
  }

  addUS_County_Data(US_County_Data: US_County_Data): Observable<US_County_Data> {
    console.log(US_County_Data)
    return this.http.post<US_County_Data>(this.url + '/add', US_County_Data, this.httpOptions).pipe(
      catchError(this.handleError<US_County_Data>(`addUS_County_Data`))
    )
  }

  addAllUS_County_Data(): Observable<Boolean> {
    return this.http.get<Boolean>(this.url + '/addAll', this.httpOptions).pipe(
      catchError(this.handleError<Boolean>(`addAllUS_County_Data`, ))
    );
  }
  
  // getWorkOrderByCustomerId(customerId: number): Observable<WorkOrder[]> {
  //   return this.http.get<WorkOrder[]>(this.url + '/vehicle/customer/' + customerId, this.httpOptions).pipe(
  //     catchError(this.handleError<WorkOrder[]>(`getWorkOrderByCustomerId`, []))
  //   );
  // }
  
  // getWorkOrderByVin(vin: number): Observable<WorkOrder[]> {
  //   return this.http.get<WorkOrder[]>(this.url + '/vehicle/vin/' + vin, this.httpOptions).pipe(
  //     catchError(this.handleError<WorkOrder[]>(`getWorkOrder`, ))
  //   );
  // }
  
  // getWorkOrderByPhone(phone: number): Observable<WorkOrder[]> {
  //   console.log('getting work orders by phone: ' + phone)
  //   return this.http.get<WorkOrder[]>(this.url + '/vehicle/customer/phone/' + phone, this.httpOptions).pipe(
  //     catchError(this.handleError<WorkOrder[]>(`getWorkOrder`, ))
  //   );
  // }

  // getCompletedWorkOrder(): Observable<WorkOrder[]> {
  //   return this.http.get<WorkOrder[]>(this.url + '/complete', this.httpOptions).pipe(
  //     catchError(this.handleError<WorkOrder[]>(`getCompletedWorkOrder`, []))
  //   );
  // }

  // getOpenWorkOrders(): Observable<WorkOrder[]> {
  //   return this.http.get<WorkOrder[]>(this.url + '/pending', this.httpOptions);
  // }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    }
  }
}

