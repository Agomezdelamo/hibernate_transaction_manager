package com.javierferrandiz.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.javierferrandiz.hibernate.dao.AlojamientoDAO;
import com.javierferrandiz.hibernate.data.entity.Alojamiento;

@Service("alojamientoService")
public class AlojamientoService {
	
	public void guardar(Alojamiento alojamiento) {
		this.alojamientoDAO.actualizarAlojamiento(alojamiento);
	}
	
	public List<Alojamiento> obtenerAlojamientosPorNumeroHabitaciones(Integer numHabitaciones) {
		return alojamientoDAO.findAlojamientosByNumHabitaciones(numHabitaciones);
	}
	
	public List<Alojamiento> obtenerAlojamientos() {
		return this.alojamientoDAO.findAllAlojamientos();
	}
	
	@Autowired
	@Qualifier("alojamientoDAO")
	private AlojamientoDAO alojamientoDAO;
	public void setAlojamientoDAO(AlojamientoDAO alojamientoDAO) {
		this.alojamientoDAO = alojamientoDAO;
	}
	
	public static void main( String[] args ) throws Exception {
    	ApplicationContext ctxt = null;
		ctxt = new FileSystemXmlApplicationContext("src/main/resources/com/javierferrandiz/spring/core/spring-beans.xml");
		AlojamientoService alojamientoService = (AlojamientoService)ctxt.getBean("alojamientoService");
		
//    	Alojamiento alojamiento = new Alojamiento();
//    	alojamiento.setNombre("MOTEL Maimonides");
//    	alojamiento.setDireccion("Sanchez Acosta nº32");
//    	alojamiento.setTelefono("953990045");
//    	alojamiento.setNumHabit(21);
//    	
//    	alojamientoService.guardar(alojamiento);
    	
    	List<Alojamiento> alojamientos = null;

    	alojamientos = alojamientoService.obtenerAlojamientosPorNumeroHabitaciones(21);
    	for(Alojamiento aloja:alojamientos) {
    		System.out.println("ID : " + aloja.getId());
    		System.out.println("NOMBRE ALOJAMIENTO : " + aloja.getNombre());
    		System.out.println("DIRECCION ALOJAMIENTO : " + aloja.getDireccion());
    		System.out.println("TELEFONO : " + aloja.getTelefono());
    		System.out.println("NUM HABITACIONES : " + aloja.getNumHabit());
    	}
    	
    	if(((FileSystemXmlApplicationContext)ctxt).isActive()) ((ConfigurableApplicationContext)ctxt).close();
	}
}
