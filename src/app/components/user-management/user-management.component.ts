import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Se você precisar de FormsModule aqui
import { SubmitProjectFormModule } from '../submit-project-form/submit-project.module'; // Importe o novo módulo

@Component({
  selector: 'app-user-management',
  standalone: true,
  imports: [CommonModule, FormsModule, SubmitProjectFormModule], // Use o módulo em vez do componente
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent {
  showForm: boolean = false;

  toggleForm() {
    this.showForm = !this.showForm; // Alterna o valor de showForm
  }
}
