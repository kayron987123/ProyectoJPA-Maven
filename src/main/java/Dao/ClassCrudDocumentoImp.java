package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IDocumentoable;
import model.TblDocumento;

public class ClassCrudDocumentoImp implements  IDocumentoable{

	@Override
	public void RegistrarDocumento(TblDocumento tbldocum) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
				
		//permite gestionar entidades
		EntityManager eman= fabri.createEntityManager();
				
		//iniciar transaccion
		eman.getTransaction().begin();
				
		//actualizamos
		eman.persist(tbldocum);
				
		//confirmamos
		eman.getTransaction().commit();
				
		//cerramos
		eman.close();
		
	}	//fin de registrar documento

	@Override
	public void ActualizarDocumento(TblDocumento tbldocum) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
		
		//permite gestionar entidades
		EntityManager eman= fabri.createEntityManager();
		
		//iniciar transaccion
		eman.getTransaction().begin();
		
		//actualizamos
		eman.merge(tbldocum);
		
		//confirmamos
		eman.getTransaction().commit();
		
		//cerramos
		eman.close();
		
	}	//fin de actualizar documento

	@Override
	public void EliminarDocumento(TblDocumento tbldocum) {
		//
		
	}	//fin de eliminar documento

	@Override
	public List<TblDocumento> ListadoDocumentos() {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
						
		//permite gestionar entidades
		EntityManager eman= fabri.createEntityManager();
						
		//iniciar transaccion
		eman.getTransaction().begin();
		
		List<TblDocumento> listado = eman.createQuery("select docu from TblDocumento docu").getResultList();
		
		return listado;
	}	//fin de listar documento

	@Override
	public TblDocumento BuscarDocumento(TblDocumento tbldocum) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
						
		//permite gestionar entidades
		EntityManager eman= fabri.createEntityManager();
						
		//iniciar transaccion
		eman.getTransaction().begin();
		
		TblDocumento buscado = eman.find(TblDocumento.class, tbldocum.getIddocument());
		
		return buscado;
	}	//fin de buscar documento
	
}
