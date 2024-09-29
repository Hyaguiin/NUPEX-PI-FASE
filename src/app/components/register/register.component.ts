import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; 

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterModule], 
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'] 
})
export class RegisterComponent {
  constructor(private router: Router) {}

  onSubmit() {
    

    this.router.navigate(['/login']); 
  }
}
