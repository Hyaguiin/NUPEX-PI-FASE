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
  collaboratorName: string = '';
  collaboratorEmail: string = '';
  coordinatorCourse: string = '';
  coordinatorPhone: string = '';
  studentCourse: string = '';
  studentPhone: string = '';

  // Array de cursos
  courses: string[] = [
    'Curso A',
    'Curso B',
    'Curso C',
    'Curso D'
  ];

  submit() {
    // Lógica para submissão do formulário
    console.log({
      projectTitle: this.projectTitle,
      projectType: this.projectType,
      periodicity: this.periodicity,
      coordinatorName: this.coordinatorName,
      coordinatorEmail: this.coordinatorEmail,
      collaboratorName: this.collaboratorName,
      collaboratorEmail: this.collaboratorEmail,
      coordinatorCourse: this.coordinatorCourse,
      coordinatorPhone: this.coordinatorPhone,
      studentCourse: this.studentCourse,
      studentPhone: this.studentPhone,
    });
    // Aqui você pode adicionar a lógica para enviar os dados para o servidor ou realizar outras ações.
  }
}
