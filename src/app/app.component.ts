import { Component, importProvidersFrom } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {
  HttpClientModule,
  provideHttpClient,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { AuthInterceptor } from './auth/auth.interceptor';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { UserManagementComponent } from './components/user-management/user-management.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    RegisterComponent,
    LoginComponent,
    UserManagementComponent,
    HttpClientModule,
  ],

  providers: [
    
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
  ],

  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'NUPEX-PI-FRONT';
}
