package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IEmpleadoable;
import model.TblEmpleado;

public class ClassCrudEmpleadoImp implements IEmpleadoable{

	@Override
	public void RegistrarEmpleado(TblEmpleado tblemp) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
		
		//manejador de entidades segun unidad de persistencia
		EntityManager entitymanag = conex.createEntityManager();
		
		//realizamos el proceso
			//iniciar transaccion
		entitymanag.getTransaction().begin();
		
		//registramos datos
		entitymanag.persist(tblemp);
		
		//confirmamos
		entitymanag.getTransaction().commit();
		
		//cerramos
		entitymanag.close();
		
	}	//fin del metodo registrar

	@Override
	public void ActualizarEmpleado(TblEmpleado tblemp) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
				
		//manejador de entidades segun unidad de persistencia
		EntityManager entitymanag = conex.createEntityManager();
				
		//realizamos el proceso
			//iniciar transaccion
		entitymanag.getTransaction().begin();
		
		//actualizamos datos
		entitymanag.merge(tblemp);
		
		//confirmamos
		entitymanag.getTransaction().commit();
		
		//cerramos
		entitymanag.close();
		
	}	//fin del metodo actualizar

	@Override
	public void EliminarEmpleado(TblEmpleado tblemp) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
				
		//manejador de entidades segun unidad de persistencia
		EntityManager entitymanag = conex.createEntityManager();
				
		//realizamos el proceso
			//iniciar transaccion
		entitymanag.getTransaction().begin();
		
		//recuperar el codigo a eliminar
		TblEmpleado elim = entitymanag.merge(tblemp);
		
		//eliminamos el dato de la base de datos
		entitymanag.remove(elim);
		
		//confirmamos
		entitymanag.getTransaction().commit();
		
		//cerramos
		entitymanag.close();
		
	}	//fin del metodo eliminar

	@Override
	public List<TblEmpleado> ListadoEmpleado() {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
						
		//manejador de entidades segun unidad de persistencia
		EntityManager entitymanag = conex.createEntityManager();
						
		//realizamos el proceso
			//iniciar transaccion
		entitymanag.getTransaction().begin();
		
		//aplicamos JPQL se base en entidades
		List<TblEmpleado> listado = entitymanag.createQuery("select e from TblEmpleado e",TblEmpleado.class).getResultList();
		
		//confirmamos
		entitymanag.getTransaction().commit();
		
		//cerramos
		entitymanag.close();
		
		return listado;
		
	}	//fin del metodo listar

	@Override
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado tblemp) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
								
		//manejador de entidades segun unidad de persistencia
		EntityManager entitymanag = conex.createEntityManager();
								
		//realizamos el proceso
			//iniciar transaccion
		entitymanag.getTransaction().begin();
		
		//enviamos el codigo a buscar en base de datos
		TblEmpleado buscar = entitymanag.find(TblEmpleado.class, tblemp.getIdempleado());
		
		//confirmamos
		entitymanag.getTransaction().commit();
		
		//cerramos
		entitymanag.close();
		
		//retornamos el valor buscado
		return buscar;
		
	}	//fin del metodo buscar

} //fin de la clase
