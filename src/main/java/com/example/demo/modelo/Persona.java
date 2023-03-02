package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(generator="seq_pers",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_pers",sequenceName="seq_pers", allocationSize=1)
	@Column(name="pers_id")
	private Integer Id;
	@Column(name="pers_nombre")
	private String nombre;
	@Column(name="pers_cedula")
	private String cedula;
	@Column(name="pers_apellido")
	private String apellido;
	@Column(name="pers_genero")
	private String genero;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Persona [Id=" + Id + ", nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido
				+ ", genero=" + genero + "]";
	}
}
