import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; 
import { SubmitProjectFormModule } from '../submit-project-form/submit-project.module'; 

@Component({
  selector: 'app-user-management',
  standalone: true,
  imports: [CommonModule, FormsModule, SubmitProjectFormModule], 
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent {
  showForm: boolean = false;

  toggleForm() {
    this.showForm = !this.showForm; 
  }
}
