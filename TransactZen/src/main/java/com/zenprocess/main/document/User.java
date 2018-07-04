package com.zenprocess.main.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private Integer id;
	private Integer idDepartamento;
	private Integer idRol;
	
	private String nombre;
	private String apellido;
	
	public User() {
	}

	public User(Integer id, Integer idDepartamento, Integer idRol, String nombre, String apellido) {
		super();
		this.id = id;
		this.idDepartamento = idDepartamento;
		this.idRol = idRol;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
