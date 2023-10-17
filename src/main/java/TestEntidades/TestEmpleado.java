package TestEntidades;

import java.util.Date;
import java.util.List;

import Dao.ClassCrudEmpleadoImp;
import model.TblEmpleado;

public class TestEmpleado {

	public static void main(String[] args) {
		//realizamos las respectivas instancias
		TblEmpleado tblemp = new TblEmpleado();
		ClassCrudEmpleadoImp crud = new ClassCrudEmpleadoImp();
		/*
		//ingresamos valores
		tblemp.setNombre("Olegario Bruno");
		tblemp.setApellido("Cueva Cueva");
		tblemp.setSexo("M");
		tblemp.setEmail("olegariobruno@gmail.com");
		tblemp.setDni("76930528");
		tblemp.setTelf("9557485");
		//convertimos la fecha a javasql
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		tblemp.setFechanac(fechasql);
		
		//invocamos al metodo registrar
		crud.RegistrarEmpleado(tblemp);
		
		//emitimos un mensaje por consola
		System.out.println("datos registrados en BD");
		*/
		
		//*************** Testeando el metodo actualizar ************
		
		/*tblemp.setIdempleado(2);
		tblemp.setNombre("Nilson Alexander");
		tblemp.setApellido("Silva Silva");
		tblemp.setSexo("M");
		tblemp.setEmail("nilson@gmail.com");
		tblemp.setDni("1045787458");
		tblemp.setTelf("5556938");
		//convertimos la fecha a sql
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		
		tblemp.setFechanac(fechasql);
		
		//actualizamos
		crud.ActualizarEmpleado(tblemp);
		
		//emitimos un mensaje por consola
		System.out.println("datos actualizamos en la BD");
		*/
		
		//*************** Testeando el metodo eliminar *******************
		/*
		tblemp.setIdempleado(5);
		
		crud.EliminarEmpleado(tblemp);
		
		//emitimos mensaje por consola
		System.out.println("dato eliminado en la BD");
		*/
		
		//************** Testeando el metodo listar *********************
		/*
		List<TblEmpleado> listado = crud.ListadoEmpleado();
		
		//aplicamos un bucle
		for(TblEmpleado list:listado){
			//imprimimos por pantalla
			System.out.println("codigo :" + list.getIdempleado() + 
							   " nombre :" + list.getNombre() + 
							   " apellido :" + list.getApellido() +
							   " sexo :" + list.getSexo() + 
							   " email :" + list.getEmail() + 
							   " dni :" + list.getDni() + 
							   " telefono :" + list.getTelf() + 
							   " Fecha Nac. :" + list.getFechanac());
		}
		*/
		
		//************ Testeando el metodo buscar **************************
		
		tblemp.setIdempleado(2);
		
		TblEmpleado buscarcod = crud.BuscarEmpleadoCodigo(tblemp);
		
		//imprimimos por pantalla
		
		System.out.println("codigo: " + buscarcod.getIdempleado() + 
						   " nombre: " + buscarcod.getNombre() + 
						   " apellido: " + buscarcod.getApellido() + 
						   " sexo: " + buscarcod.getSexo() + 
						   " email: " + buscarcod.getEmail() + 
						   " dni: " + buscarcod.getDni() + 
						   " telefono: " + buscarcod.getTelf() + 
						   " fecha nac.: " + buscarcod.getFechanac());
		
	}	//fin del metodo principal

}	//fin de la clase testempleado
