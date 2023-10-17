package TestEntidades;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblCategoria;
import model.TblProducto;

public class TestProducto {

	public static void main(String[] args) {
		//establecer conexion con la unidad de persistencia
		EntityManagerFactory facto = Persistence.createEntityManagerFactory("BDAutoJPA");
		
		//manejador de entidades
		EntityManager eman = facto.createEntityManager();
		
		//procesos:registrar, actulizar, listar, etc...
		//iniciamos transaccion
		eman.getTransaction().begin();
		
		//instanciamos las respectivas entidades
		TblCategoria tblcat = new TblCategoria();
		TblProducto tblprod = new TblProducto();
		/*
		//********** registrar *************
		tblcat.setNomcateg("Otros");
		tblcat.setDescrip("producto de alto y bajo precio");
		
		//********* ingresamos datos a la tabla productos ***********
		tblprod.setNomprod("ceterizina");
		tblprod.setPrecio(14);
		Date fech = new Date();
		Date fechasql = new Date(fech.getTime());
		tblprod.setFechavenc(fechasql);
		tblprod.setCodbarras("7578963");
		tblprod.setNrolote("L785485");
		
		//asignamos el objeto tblcat
		tblprod.setTblCategoria(tblcat);
		eman.persist(tblprod);
		
		//emitimos mensaje por pantalla
		System.out.println("Dato ingresado");
		
		//confirmamos
		eman.getTransaction().commit();
		
		//cerramos
		eman.close();
		*/
		//********* actualizar ***************
		tblcat.setIdcategoria(1);
		tblcat.setNomcateg("Generico");
		tblcat.setDescrip("Recomendado por el Ministerio de Salud");
		tblprod.setIdproducto(1);
		tblprod.setNomprod("paracetamol");
		tblprod.setPrecio(8);
		Date fech = new Date();
		Date fechasql = new Date(fech.getTime());
		tblprod.setFechavenc(fechasql);
		tblprod.setCodbarras("7755777");
		tblprod.setNrolote("L33333");
		
		tblprod.setTblCategoria(tblcat);
		eman.merge(tblprod);
		
		System.out.println("Dato actualizado");
		
		eman.getTransaction().commit();
		
		eman.close();
		
	}	//fin del metodo main

}	//fin de la clase testproducto
