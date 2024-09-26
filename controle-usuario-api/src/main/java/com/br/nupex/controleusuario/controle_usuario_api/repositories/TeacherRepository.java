package com.br.nupex.controleusuario.controle_usuario_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.nupex.controleusuario.controle_usuario_api.domain.user.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, String> {
   
}
