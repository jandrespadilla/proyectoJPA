package com.coderhouse;
 

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.modelo.Alumno;
import com.coderhouse.modelo.Categoria;
import com.coderhouse.modelo.Curso;

@SpringBootApplication
public class ProyectoJpaApplication implements CommandLineRunner{
	
	@Autowired
	private DaoFactory dao;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoJpaApplication.class, args);
	}
    @Override
	public void run(String... arg) {
		try {
			Categoria categoria1 = new Categoria ("FrontEnd");
			
			Categoria categoria2 = new Categoria ("Backend");
			
			Curso curso1 = new Curso ("HTML",categoria1);
			Curso curso2 = new Curso ("JAVA",categoria2);
			Curso curso3 = new Curso ("JAVASCRIPT",categoria1);
			Curso curso4 = new Curso ("PHP",categoria2);
			Alumno alumno1 = new Alumno ("Andres","padilla", 2878932,"L2878932");			
			Alumno alumno2 = new Alumno ("Seba","Gaitan", 39488322,"L39488322");	
			Alumno alumno3 = new Alumno ("hugo","sanchez", 283434342,"L283434342");	
			
			
			dao.createCategoria(categoria1);
			dao.createCategoria(categoria2);
			dao.createAlumno(alumno1);
			dao.createAlumno(alumno2);
			dao.createAlumno(alumno3);
			dao.createCurso(curso1);
			dao.createCurso(curso2);
			dao.createCurso(curso3);
			dao.createCurso(curso4);
		} catch (Exception e) {
			 e.printStackTrace(System.err);
		}
		
	}

}