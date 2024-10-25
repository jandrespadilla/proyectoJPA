
package com.coderhouse.modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column( nullable = false) 
	private String nombre;
	
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinTable(
			name = "curso_alumno",
			joinColumns = @JoinColumn(name = "curso_id"),
			inverseJoinColumns = @JoinColumn(name="alumno_id")
			)
	 private List<Alumno> alumnos = new ArrayList<>();
	 
	@ManyToAny(  fetch = FetchType.EAGER)
	@JoinTable(
			name = "categoria_curso",
			joinColumns = @JoinColumn(name = "curso_id"),
			inverseJoinColumns = @JoinColumn(name="categoria_id")
			)
	
   

	 private Categoria categoria = new Categoria();
	

	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	public Curso(String nombre,Categoria categorias) {
		super();
		this.nombre = nombre;
		this.categoria = categorias;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categorias) {
		this.categoria = categorias;
	}
	
	
	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
	
}
