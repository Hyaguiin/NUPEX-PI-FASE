import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SubmitProjectFormComponent } from './submit-project-form.component';

@NgModule({
  declarations: [
    SubmitProjectFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    SubmitProjectFormComponent
  ]
})
export class SubmitProjectFormModule { }
