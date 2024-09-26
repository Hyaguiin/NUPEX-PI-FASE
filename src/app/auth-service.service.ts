import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  
  private apiUrl: string = 'http://localhost:8080/auth';
  constructor(private http: HttpClient) {}

 login(credentials: {username: string, password: string}): Observable<any>{
  return this.http.post(`${this.apiUrl}/login`, credentials).pipe(
    map((response: any)=>{ 
      if(response && response.token){
        localStorage.setItem('token', response.token);
      }
      return response;
    })
  )
 }
  
 register(credentials:{username: string, password:string}):Observable<any>{
  return this.http.post(`${this.apiUrl}/register`, credentials)
 }

 isLoggedIn():boolean{
  return !!localStorage.getItem('token');
 }

 isLogout(): void{
  return localStorage.removeItem('token');
 }

 getToken(): string | null{
  return localStorage.getItem('token');
 }


 isAdmin(): boolean{
  const token = this.getToken();
  if(token){
    const payLoad = JSON.parse(atob(token.split('.')[1]));
    return payLoad.roles.includes('ROLE_ADMIN');
  }
  return false;
 }
}


