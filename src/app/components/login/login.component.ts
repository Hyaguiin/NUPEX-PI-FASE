import { Component } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { AuthServiceService } from '../../auth/auth-service.service';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  credentials = { username: '', password: '' };
  errorMessage: string = '';

  constructor(
    private authService: AuthServiceService,
    private router: Router
  ) {}

  login() {
    if (!this.credentials.username || !this.credentials.password) {
      this.errorMessage = 'Por favor, preencha todos os campos.';
      return;
    }

    this.authService.login(this.credentials).subscribe({
      next: () => {
        this.router.navigate(['/user-management']);
        this.errorMessage = '';
      },
      error: (err) => {
        console.error('Erro de login:', err);
        this.errorMessage = 'Credenciais inválidas ou erro no servidor.';
      },
    });
  }
}
