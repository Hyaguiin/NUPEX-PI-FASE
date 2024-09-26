package com.br.nupex.controleusuario.controle_usuario_api.infra.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.nupex.controleusuario.controle_usuario_api.domain.user.Teacher;
import com.br.nupex.controleusuario.controle_usuario_api.exceptions.FailedToCreate;
import com.br.nupex.controleusuario.controle_usuario_api.exceptions.FailedToDelete;
import com.br.nupex.controleusuario.controle_usuario_api.exceptions.FailedToUpdate;
import com.br.nupex.controleusuario.controle_usuario_api.exceptions.NotFound;
import com.br.nupex.controleusuario.controle_usuario_api.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> getAllTeachers() {
		try {
			return teacherRepository.findAll();
		} catch (NotFound E) {
			throw new NotFound("User Not Found!");
		}
	}

	public Optional<Teacher> getTeacherById(String id) {
		try {
			return teacherRepository.findById(id);
		} catch (NotFound err) {
			throw new NotFound("Id not found: " + id);
		}
	}

	public Teacher createTeacher(Teacher teacher) {
		try {
			return teacherRepository.save(teacher);
		} catch (FailedToCreate E) {
			throw new FailedToCreate("Something Wrong in Creation");
		}
	}

	public Optional<Teacher> updateTeacher(String id, Teacher teacher) {
		try {
			return teacherRepository.findById(id).map(existingTeacher -> {
				teacher.setId(id);
				return teacherRepository.save(teacher);
			});
		} catch (FailedToUpdate E) {
			throw new FailedToUpdate("Something Wrong in Update " + id);
		}
	}

	public boolean deleteTeacher(String id) {
		try {
			if (teacherRepository.existsById(id)) {
				teacherRepository.deleteById(id);
				return true;
			}
			return false;
		} catch (FailedToDelete E) {
			throw new FailedToDelete("Something wrong in Delete " + id);
		}
	}
}
