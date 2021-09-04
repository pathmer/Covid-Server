import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { US_Cases_Deaths } from '../interfaces/US_Cases_Deaths';
// import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class UsCasesDeathsService {

  constructor(private http: HttpClient) { } // , private cookieService: CookieService

  url: string = 'http://localhost:8080/Covid_Server/US_Cases_Deaths';
  // url: string = `http://ec2-54-67-83-160.us-west-1.compute.amazonaws.com:8080/Project%202/workorders`;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }) // , 'Authorization': this.cookieService.get('auth')
  };

  getAllUS_Cases_Deaths(): Observable<US_Cases_Deaths[]> {
    return this.http.get<US_Cases_Deaths[]>(this.url, this.httpOptions).pipe(
      catchError(this.handleError<US_Cases_Deaths[]>(`getAllUS_Cases_Deaths`, []))
    );
  }

  getUS_Cases_Deaths(id: number): Observable<US_Cases_Deaths> {
    return this.http.get<US_Cases_Deaths>(this.url + '/' + id, this.httpOptions).pipe(
      catchError(this.handleError<US_Cases_Deaths>(`getUS_Cases_Deaths`, ))
    );
  }
  
  updateUS_Cases_Deaths(US_Cases_Deaths: US_Cases_Deaths): Observable<US_Cases_Deaths> {
    return this.http.put<US_Cases_Deaths>(this.url + '/update', US_Cases_Deaths, this.httpOptions).pipe(
      catchError(this.handleError<US_Cases_Deaths>(`updateUS_Cases_Deaths`))
    );
  }

  addUS_Cases_Deaths(US_Cases_Deaths: US_Cases_Deaths): Observable<US_Cases_Deaths> {
    console.log(US_Cases_Deaths)
    return this.http.post<US_Cases_Deaths>(this.url + '/add', US_Cases_Deaths, this.httpOptions).pipe(
      catchError(this.handleError<US_Cases_Deaths>(`addUS_Cases_Deaths`))
    )
  }

  addAllUS_Cases_Deaths(): Observable<Boolean> {
    return this.http.get<Boolean>(this.url + '/addAll', this.httpOptions).pipe(
      catchError(this.handleError<Boolean>(`addAllUS_Cases_Deaths`, ))
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
