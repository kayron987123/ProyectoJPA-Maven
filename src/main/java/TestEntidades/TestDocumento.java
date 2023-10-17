package TestEntidades;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblDocumento;
import model.TblTipodocumento;

public class TestDocumento {

	public static void main(String[] args) {
		//establecemos conexion con la unidad de persistencia...
		EntityManagerFactory fabri = Persistence.createEntityManagerFactory("BDAutoJPA");
		
		//permite gestionar entidades
		EntityManager eman = fabri.createEntityManager();
		
		//iniciar transaccion
		eman.getTransaction().begin();
		
		//instanciar las respectivas entidades
		TblTipodocumento tipodocu = new TblTipodocumento();
		TblDocumento docum = new TblDocumento();
		
		//********* registrar **********
		//ingresando nuevos valores
		/*tipodocu.setNomdocum("factura");
		tipodocu.setDescripdocum("comprobante de pago");
		eman.persist(tipodocu);
		
		docum.setNrodocument("6664443");
		docum.setProvedocument("pc leticia e.i.r.l");
		docum.setRucdocumen("487896537942");
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		docum.setFecha(fechasql);
		docum.setDescridocument("recolectar IGV para la sunat");
		docum.setTblTipodocumento(tipodocu);
		eman.persist(docum);
		
		//emitimos un mensaje por consola
		System.out.println("Dato registrado");
		
		//confirmamos
		eman.getTransaction().commit();
		
		//cerramos
		eman.close();
		*/
		//********* actualizar ************
		/*tipodocu.setIdtipodocum(1);
		tipodocu.setNomdocum("ticket");
		tipodocu.setDescripdocum("para llevar control interno");
		eman.merge(tipodocu);
		
		docum.setIddocument(1);
		docum.setNrodocument("555556");
		docum.setProvedocument("policlinico lima");
		docum.setRucdocumen("22020457896");
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		docum.setFecha(fechasql);
		docum.setDescridocument("comprobante de pago");
		docum.setTblTipodocumento(tipodocu);
		eman.merge(docum);
		
		System.out.println("dato actualizado");
		
		eman.getTransaction().commit();
		
		eman.close();
		*/
		//********** listado *************
		/*List<TblDocumento> listado = eman.createQuery("select docu from TblDocumento docu",TblDocumento.class).getResultList();
		
		//aplicamos un bucle for
		for(TblDocumento list:listado){
			System.out.println("codigo: " + list.getIddocument() + " nro de documento:" + list.getNrodocument() + 
					" nombre de proveedor:" + list.getProvedocument() + " ruc de docum:" + list.getRucdocumen() + " fecha:" + list.getFecha() + 
					" descrip document:" + list.getDescridocument() + " codigo tipo documento:" + list.getTblTipodocumento().getIdtipodocum() + 
					" nombre documento:" + list.getTblTipodocumento().getNomdocum() + " nombre documento:" + list.getTblTipodocumento().getDescripdocum());
		}*/
		
		//*********** buscar por codigo ***********
		TblDocumento buscarcodigo = eman.find(TblDocumento.class, 1);
		
		System.out.println("codigo documento:" + buscarcodigo.getIddocument() + " nro de documento:" + buscarcodigo.getNrodocument() + 
				" nombre proveedor:" + buscarcodigo.getProvedocument() + " ruc de documento:" + buscarcodigo.getRucdocumen() +
				" fecha documento:" + buscarcodigo.getFecha() + " descrip documento" + buscarcodigo.getDescridocument() +
				" codigo tipo documento:" + buscarcodigo.getTblTipodocumento().getIdtipodocum() + "nombre tipo de documento" + 
				buscarcodigo.getTblTipodocumento().getNomdocum() + " descripcion tipo documento" + buscarcodigo.getTblTipodocumento().getDescripdocum());
		
	}	//fin del metodo main

}	//fin del testdocumento
