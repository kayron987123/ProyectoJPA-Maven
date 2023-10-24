package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IAutoable;
import model.TblAuto;

public class ClassCrudAutoImp implements IAutoable {

	@Override
	public void RegistrarAuto(TblAuto tblauto) {
		//establecemos con la unidad de persistencia
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoMavenLPIIMartes");
		
		//para gestionar los procesos
		EntityManager manager = factory.createEntityManager();
		
		//iniciamos la transaccion
		manager.getTransaction().begin();
		
		//registramos
		manager.persist(tblauto);
		
		//confirmamos
		manager.getTransaction().commit();
		
		//cerrar
		manager.close();
		
	}//fin del metodo registrar

	@Override
	public void ActualizarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}//fin del metodo actualizar

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}//fin del metodo eliminar

	@Override
	public List<TblAuto> ListadoAuto() {
		//establecemos la unidad de persistencia
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProyectoMavenLPIIMartes");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		List<TblAuto> listaAuto = manager.createQuery("select a from TblAuto a", TblAuto.class).getResultList();
		
		manager.getTransaction().commit();
		
		manager.close();
		
		return listaAuto;
	}//fin del metodo listar

	@Override
	public TblAuto BuscarAuto() {
		// TODO Auto-generated method stub
		return null;
	}//fin del metodo buscar	

}
