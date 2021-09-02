import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { US_County } from '../interfaces/US_County';
// import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class UsCountiesService {

  constructor(private http: HttpClient) { } // , private cookieService: CookieService

  url: string = 'http://localhost:8080/US_Counties';
  // url: string = `http://ec2-54-67-83-160.us-west-1.compute.amazonaws.com:8080/Project%202/workorders`;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }) // , 'Authorization': this.cookieService.get('auth')
  };

  getAllUS_County(): Observable<US_County[]> {
    return this.http.get<US_County[]>(this.url, this.httpOptions).pipe(
      catchError(this.handleError<US_County[]>(`getAllUS_County`, []))
    );
  }

  getUS_County(id: number): Observable<US_County> {
    return this.http.get<US_County>(this.url + '/' + id, this.httpOptions).pipe(
      catchError(this.handleError<US_County>(`getUS_County`, ))
    );
  }
  
  updateUS_County(US_County: US_County): Observable<US_County> {
    return this.http.put<US_County>(this.url + '/update', US_County, this.httpOptions).pipe(
      catchError(this.handleError<US_County>(`updateUS_County`))
    );
  }

  addUS_County(US_County: US_County): Observable<US_County> {
    console.log(US_County)
    return this.http.post<US_County>(this.url + '/add', US_County, this.httpOptions).pipe(
      catchError(this.handleError<US_County>(`addUS_County`))
    )
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
