package com.javierferrandiz.hibernate.data.entity;

import java.util.HashSet;
import java.util.Set;



public class Actividad implements java.io.Serializable {
	private Integer id;
	private String nombreActi;
	private String descripcion;
	private String nivel;
	private Set<Alojamiento> alojamientos = new HashSet<Alojamiento>(0);
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreActi() {
		return nombreActi;
	}
	public void setNombreActi(String nombreActi) {
		this.nombreActi = nombreActi;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Set<Alojamiento> getAlojamientos() {
		return alojamientos;
	}
	public void setAlojamientos(Set<Alojamiento> alojamientos) {
		this.alojamientos = alojamientos;
	}
	public void addAlojamiento(Alojamiento alojamiento){
		alojamiento.getActividades().add(this);
		alojamientos.add(alojamiento);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nombreActi == null) ? 0 : nombreActi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		if (nombreActi == null) {
			if (other.nombreActi != null)
				return false;
		} else if (!nombreActi.equals(other.nombreActi))
			return false;
		return true;
	}
	
}
