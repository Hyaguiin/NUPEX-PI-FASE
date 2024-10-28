import { Component } from '@angular/core';

@Component({
  selector: 'app-submit-project-form',
  templateUrl: './submit-project-form.component.html',
  styleUrls: ['./submit-project-form.component.scss']
})
export class SubmitProjectFormComponent {
  projectTitle: string = '';
  projectType: string = '';
  periodicity: string = '';
  coordinatorName: string = '';
  coordinatorEmail: string = '';
  coordinatorCourse: string = '';
  coordinatorPhone: string = '';
  collaboratorName: string = '';
  collaboratorEmail: string = '';
  collaboratorCourse: string = '';
  collaboratorPhone: string = '';
  modality: string = '';

  // Listas de opções
  courses: string[] = ['Curso A', 'Curso B', 'Curso C', 'Curso D'];
  coordinatorOptions: string[] = ['Professor 1', 'Professor 2', 'Professor 3'];
  collaboratorOptions: string[] = ['Professor A', 'Professor B', 'Professor C'];

  submit() {
    const formData = {
      projectTitle: this.projectTitle,
      projectType: this.projectType,
      periodicity: this.periodicity,
      coordinatorName: this.coordinatorName,
      coordinatorEmail: this.coordinatorEmail,
      coordinatorCourse: this.coordinatorCourse,
      coordinatorPhone: this.coordinatorPhone,
      collaboratorName: this.collaboratorName,
      collaboratorEmail: this.collaboratorEmail,
      collaboratorCourse: this.collaboratorCourse,
      collaboratorPhone: this.collaboratorPhone,
      modality: this.modality
    };

    console.log('Form Data:', formData);
  }
}
