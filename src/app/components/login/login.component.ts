import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../../auth/auth-service.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  email: string = '';
  senha: string = '';
  mensagemErro: string = '';
  lembrarDispositivo: boolean = false;

  constructor(
    private authService: AuthServiceService,
    private router: Router
  ) {}

  login() {
    const credentials = { email: this.email, password: this.senha };
    this.authService
      .login(credentials.email, credentials.password, credentials)
      .subscribe(
        (response: { success: boolean }) => {
          if (response.success) {
            this.router.navigate(['/user-management']);
          } else {
            this.mensagemErro = 'Email ou senha incorretos.';
          }
        },
        (error: any) => {
          this.mensagemErro = 'Ocorreu um erro. Tente novamente mais tarde.';
          console.error(error);
        }
      );
  }
}
