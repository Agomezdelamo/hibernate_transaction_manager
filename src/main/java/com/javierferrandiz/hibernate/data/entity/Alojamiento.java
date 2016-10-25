package com.javierferrandiz.hibernate.data.entity;

import java.util.HashSet;
import java.util.Set;



public class Alojamiento implements java.io.Serializable {
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	private Integer numHabit;
	private Personal contacto;
	private Set<Personal> empleados = new HashSet<Personal>(0);
	private Set<Habitacion> habitaciones = new HashSet<Habitacion>(0);
	private Set<Actividad> actividades = new HashSet<Actividad>(0);
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getNumHabit() {
		return numHabit;
	}
	public void setNumHabit(Integer numHabit) {
		this.numHabit = numHabit;
	}
	public Personal getContacto() {
		return contacto;
	}
	public void setContacto(Personal contacto) {
		this.contacto = contacto;
	}
	public Set<Personal> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Personal> empleados) {
		this.empleados = empleados;
	}
	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public Set<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public void addPersonal(Personal personal){
		personal.setAlojamiento(this);
		this.empleados.add(personal);
	}
	public void addHabitacion(Habitacion habitacion){
		habitacion.setAlojamiento(this);
		habitaciones.add(habitacion);
	}
	public void addActividad(Actividad actividad){
		actividad.getAlojamientos().add(this);
		actividades.add(actividad);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Alojamiento other = (Alojamiento) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
