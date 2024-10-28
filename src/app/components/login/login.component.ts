import { Component } from '@angular/core';
import { AuthServiceService } from '../../auth/auth-service.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(
    private authService: AuthServiceService,
    private router: Router
  ) {}

  login(): void {
    const credentials = { username: this.username, password: this.password };

    this.authService.login(credentials).subscribe({
      next: (response) => {
        this.router.navigate(['/home']);
      },
      error: (error: HttpErrorResponse) => {
        this.errorMessage = 'Credenciais inválidas';
        console.error('Erro ao fazer login:', error);
      },
    });
  }
}
