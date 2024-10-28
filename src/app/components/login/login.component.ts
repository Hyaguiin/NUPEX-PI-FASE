import { Component } from '@angular/core';
<<<<<<< HEAD
import { AuthServiceService } from '../../auth/auth-service.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
=======
import { RouterModule, Router } from '@angular/router'; // Importando RouterModule e Router
>>>>>>> 3aa2c3b6afc5fb610ca6849b75f9c16a66ce61bb

@Component({
  selector: 'app-login',
  standalone: true,
<<<<<<< HEAD
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
=======
  imports: [RouterModule], // Importando RouterModule
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'] // Corrigido para styleUrls
})
export class LoginComponent {
  constructor(private router: Router) {} // Injetando Router

  login() {
    // Redirecionando para user-management
    this.router.navigate(['/user-management']);
>>>>>>> 3aa2c3b6afc5fb610ca6849b75f9c16a66ce61bb
  }
}
