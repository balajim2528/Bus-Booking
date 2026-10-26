import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface TicketResponse {
  message: string;
  ticketId?: string;
  status?: string;
}

@Injectable({
  providedIn: 'root'
})


@Injectable({
  providedIn: 'root',
})
export class PassengerService {

private apiUrl = 'http://localhost:8080/irctc/ticket';

  constructor(private http: HttpClient) {}

  bookTicket(data: any): Observable<any> {
  return this.http.post(this.apiUrl, data);
}



}
