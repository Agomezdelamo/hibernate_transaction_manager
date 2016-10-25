package com.javierferrandiz.hibernate.data.entity;

public class Habitacion implements java.io.Serializable {
	private Integer id;
	private Integer nuHabitacion;
	private String tipo;
	private String banio;
	private Double precio;
	private Alojamiento alojamiento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNuHabitacion() {
		return nuHabitacion;
	}
	public void setNuHabitacion(Integer nuHabitacion) {
		this.nuHabitacion = nuHabitacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getBanio() {
		return banio;
	}
	public void setBanio(String banio) {
		this.banio = banio;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Alojamiento getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alojamiento == null) ? 0 : alojamiento.hashCode());
		result = prime * result
				+ ((nuHabitacion == null) ? 0 : nuHabitacion.hashCode());
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
		Habitacion other = (Habitacion) obj;
		if (alojamiento == null) {
			if (other.alojamiento != null)
				return false;
		} else if (!alojamiento.equals(other.alojamiento))
			return false;
		if (nuHabitacion == null) {
			if (other.nuHabitacion != null)
				return false;
		} else if (!nuHabitacion.equals(other.nuHabitacion))
			return false;
		return true;
	}
	
}
