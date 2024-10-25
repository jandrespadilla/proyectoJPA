package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.modelo.Alumno;
import com.coderhouse.modelo.Categoria;
import com.coderhouse.modelo.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {

	@PersistenceContext
	private EntityManager em;
	@Transactional
	public void createAlumno(Alumno alumno) {
			em.persist(alumno);
		
	}
	@Transactional
	public void createCurso(Curso curso) {
			em.persist(curso);
		
	}
	@Transactional
	public void createCategoria(Categoria categoria) {
			em.persist(categoria);
		
	}
}
