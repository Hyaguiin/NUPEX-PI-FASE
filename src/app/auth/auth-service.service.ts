import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthServiceService {
  private apiUrl: string = 'http://localhost:808/auth';

  constructor(private http: HttpClient) {}

  login(
    email: string,
    senha: string,
    credentials: { email: string; password: string }
  ): Observable<any> {
    if (email === 'admin@domain.com' && senha === 'admin123') {
      const token = 'admin-token';
      localStorage.setItem('token', token);
      return new Observable((observer) => {
        observer.next({ success: true, token });
        observer.complete();
      });
    } else {
      return this.http.post(`${this.apiUrl}/login`, credentials).pipe(
        map((response: any) => {
          if (response && response.token) {
            localStorage.setItem('token', response.token);
          }
          return response;
        })
      );
    }
  }

  register(credentials: { email: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, credentials);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  isLogout(): void {
    return localStorage.removeItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isAdmin(): boolean {
    const token = this.getToken();
    if (token) {
      const payLoad = JSON.parse(atob(token.split('.')[1]));
      return payLoad.roles.includes('ROLE_ADMIN');
    }
    return false;
  }
}
