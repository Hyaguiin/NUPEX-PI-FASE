import { Component } from '@angular/core';
import { RouterModule, Router } from '@angular/router'; // Importando RouterModule e Router

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule], // Importando RouterModule
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'] // Corrigido para styleUrls
})
export class LoginComponent {
  constructor(private router: Router) {} // Injetando Router

  login() {
    // Redirecionando para user-management
    this.router.navigate(['/user-management']);
  }
}
