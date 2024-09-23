package com.br.nupex.controleusuario.controle_usuario_api.domain.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {

	@Id
	private String id = UUID.randomUUID().toString();

	private String projectTitle;

	@Enumerated(EnumType.STRING)
	private ProjectType projectType;

	@Enumerated(EnumType.STRING)
	private Periodicity periodicity;

	private String coordinatorName;
	private String coordinatorEmail;
	private String collaboratorName;
	private String collaboratorEmail;
	private String coordinatorCourse;
	private String coordinatorPhone;
	private String studentCourse;
	private String studentPhone;

	public Teacher() {
	}

	public Teacher(String id, String projectTitle, ProjectType projectType, Periodicity periodicity,
			String coordinatorName, String coordinatorEmail, String collaboratorName, String collaboratorEmail,
			String coordinatorCourse, String coordinatorPhone, String studentCourse, String studentPhone) {
		this.id = id != null ? id : UUID.randomUUID().toString(); 
		this.projectTitle = projectTitle;
		this.projectType = projectType;
		this.periodicity = periodicity;
		this.coordinatorName = coordinatorName;
		this.coordinatorEmail = coordinatorEmail;
		this.collaboratorName = collaboratorName;
		this.collaboratorEmail = collaboratorEmail;
		this.coordinatorCourse = coordinatorCourse;
		this.coordinatorPhone = coordinatorPhone;
		this.studentCourse = studentCourse;
		this.studentPhone = studentPhone;
	}

	// Getters e Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public String getCoordinatorEmail() {
		return coordinatorEmail;
	}

	public void setCoordinatorEmail(String coordinatorEmail) {
		this.coordinatorEmail = coordinatorEmail;
	}

	public String getCollaboratorName() {
		return collaboratorName;
	}

	public void setCollaboratorName(String collaboratorName) {
		this.collaboratorName = collaboratorName;
	}

	public String getCollaboratorEmail() {
		return collaboratorEmail;
	}

	public void setCollaboratorEmail(String collaboratorEmail) {
		this.collaboratorEmail = collaboratorEmail;
	}

	public String getCoordinatorCourse() {
		return coordinatorCourse;
	}

	public void setCoordinatorCourse(String coordinatorCourse) {
		this.coordinatorCourse = coordinatorCourse;
	}

	public String getCoordinatorPhone() {
		return coordinatorPhone;
	}

	public void setCoordinatorPhone(String coordinatorPhone) {
		this.coordinatorPhone = coordinatorPhone;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public enum Periodicity {
		SEMESTRAL, ANUAL, BIENAL, TRIENAL
	}

	public enum ProjectType {
		EXTENSAO, PESQUISA
	}

}
