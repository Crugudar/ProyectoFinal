import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {

  baseUrl: string = 'http://localhost:8080/';

  constructor(
    private http: HttpClient
  ) { }

  addMessage(message: Object): Observable<Message> {
    //let body = JSON.stringify(message);
    console.log(message)
    return this.http.post<Message>('http://localhost:8080/message', message);
    
  }

  messages(): Observable<InterfaceMessage[]> {
    //let body = JSON.stringify(message);
    return this.http.get<InterfaceMessage[]>('http://localhost:8080/messages');
  }

  markAsRead(id:number): Observable<Message> {
    //let body = JSON.stringify(message);
    return this.http.put<Message>('http://localhost:8080/message/'+id, null);
  }

  delete(id:number) {
    return this.http.delete('http://localhost:8080/message/'+id);
  }

  authenticate(user:Object): Observable<any> {
    return this.http.post<any>("http://localhost:8080/user/auth/login", user);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem("username");
  }

}
 interface InterfaceMessage{
  clientEmail: string,
  clientName: string,
  createdAt: string,
  messageBody: string,
  messageId: number,
  phone: number,
  read: boolean
  }