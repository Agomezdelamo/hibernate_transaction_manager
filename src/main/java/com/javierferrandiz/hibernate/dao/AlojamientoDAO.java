package com.javierferrandiz.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javierferrandiz.hibernate.data.entity.Alojamiento;


@Repository("alojamientoDAO")
public class AlojamientoDAO {
	public AlojamientoDAO(){

	}
	@SuppressWarnings({"unchecked"})
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Alojamiento> findAllAlojamientos() {
		return (List<Alojamiento>) this.hibernateTemplate.find("SELECT a FROM Alojamiento a");
	}
	@SuppressWarnings({"unchecked"})
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Alojamiento> findAlojamientosByNumHabitaciones(Integer numHabits) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Alojamiento.class).add(Restrictions.eq("numHabit", numHabits));
		List<Alojamiento> alojamientos = (List<Alojamiento>)this.hibernateTemplate.findByCriteria(detachedCriteria);
		return alojamientos;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor=java.lang.Throwable.class)
	public void actualizarAlojamiento(Alojamiento alojamiento) {
		this.hibernateTemplate.saveOrUpdate(alojamiento);
	}
	
    public static void main( String[] args ) throws Exception {
    	ApplicationContext ctxt = null;
		ctxt = new FileSystemXmlApplicationContext("src/main/resources/com/javierferrandiz/spring/core/spring-beans.xml");
		AlojamientoDAO alojamientoDAO = (AlojamientoDAO)ctxt.getBean("alojamientoDAO");
		
		List<Alojamiento> alojamientos = null;
		
    	alojamientos = alojamientoDAO.findAllAlojamientos();
    	for(Alojamiento alojamiento:alojamientos) {
    		System.out.println("ID : " + alojamiento.getId());
    		System.out.println("NOMBRE ALOJAMIENTO : " + alojamiento.getNombre());
    		System.out.println("DIRECCION ALOJAMIENTO : " + alojamiento.getDireccion());
    		System.out.println("TELEFONO : " + alojamiento.getTelefono());
    		System.out.println("NUM HABITACIONES : " + alojamiento.getNumHabit());
    	}
//Cuando usemos el acceso a datos por medio de la plantilla HibernateTemplate debemos comentar el parámetro "hibernate.current_session_context_class"
//    	alojamientos = null;
//    	alojamientos = alojamientoDAO.findAlojamientosByNumHabitaciones(10);
//    	for(Alojamiento alojamiento:alojamientos) {
//    		System.out.println("ID : " + alojamiento.getId());
//    		System.out.println("NOMBRE ALOJAMIENTO : " + alojamiento.getNombre());
//    		System.out.println("DIRECCION ALOJAMIENTO : " + alojamiento.getDireccion());
//    		System.out.println("TELEFONO : " + alojamiento.getTelefono());
//    		System.out.println("NUM HABITACIONES : " + alojamiento.getNumHabit());
//    	}
//    	Alojamiento alojamiento = new Alojamiento();
//    	alojamiento.setNombre("HOTEL Deifontes");
//    	alojamiento.setDireccion("Manuel Pizarro nº3");
//    	alojamiento.setTelefono("958450045");
//    	alojamiento.setNumHabit(5);
//    	try {
//    		alojamientoDAO.actualizarAlojamiento(alojamiento);
//    	}catch(Exception ex) {
//    		System.out.println(ex);
//    	} finally {
//    		if(((FileSystemXmlApplicationContext)ctxt).isActive()) ((ConfigurableApplicationContext)ctxt).close();
//    	}
    	if(((FileSystemXmlApplicationContext)ctxt).isActive()) ((ConfigurableApplicationContext)ctxt).close();
    }
    @Autowired
    @Qualifier("sessionFactory")
	private SessionFactory sessionFactory = null;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate = null;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}
}
