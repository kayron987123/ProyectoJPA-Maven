package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		//establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("ProyectoMavenLPIIMartes");//viene de persitence.xml(persitence-unit name)
		
		//gestionar entidades como registrar,actualizar,eliminar,listar,buscar
		EntityManager emanager = conex.createEntityManager();
		
		//iniciamos transaccion (iniciar la operacion como el crud)
		emanager.getTransaction().begin();
		
		//realizamos una instancia
		TblAuto auto = new TblAuto();
		
		//aplicamos un swtich
		String accion=JOptionPane.showInputDialog("Ingrese la Accion");
		switch(accion){
		
		case "Registrar":
			//ingresamos valores a enviar a la base de datos
			auto.setColor("rojoMaven");
			auto.setModelo("civicMaven");
			auto.setMotor("1.2");
			auto.setPrecio(17000);
			auto.setMarca("honda");
			auto.setFabricacion("2022");
			
			//registramos los datos con persist
			//persist...(insert into tbl_auto values(...)
			emanager.persist(auto);
			
			//emitimos un mensaje por consola
			System.out.println("Datos registrados en la BD");
			
			//confirmamos
			emanager.getTransaction().commit();
			
			//cerramos la transaccion
			emanager.close();
			
			//salimos del caso
			break;
			
		case "Actualizar":
			auto.setIdauto(4);
			auto.setColor("azul claro");
			auto.setModelo("f1");
			auto.setMotor("1.8");
			auto.setPrecio(30000);
			auto.setMarca("BMW");
			auto.setFabricacion("2023");
			
			//realizamos la actualizacion
			//merge...(update tbl_auto set color="...",modelo="...",... where idauto="5");...
			emanager.merge(auto);
			
			//emitimos un mensaje por consola
			System.out.println("Datos actualiazados correctamente");
			
			//confirmamos
			emanager.getTransaction().commit();
			
			//cerramos la transaccion
			emanager.close();
			
			//salimos del caso
			break;
			
		case "Eliminar":
			//codigo a eliminar
			auto.setIdauto(4);
			TblAuto elim = emanager.merge(auto);
			
			//realizamos la eliminacion
			//en jdbc delete from tbl_auto where idauto = ?...
			emanager.remove(elim);
			
			//imprimimos el mensaje por consola
			System.out.println("dato eliminado en la base de datos");
			
			//confirmamos
			emanager.getTransaction().commit();
			
			//cerramos
			emanager.close();
			
			//salimos del caso
			break;
			
		case "Buscar":
			//en jdbc : select * from tbl_auto where iduato = 3;...
			TblAuto busc=emanager.find(TblAuto.class, 6);
			
			//aplicamos una condicion
			if(busc == null){
				//emitimos mensajer por consola
				System.out.println("Registro no encontrado");
			}else{
				System.out.println("Registro encontrado");
				//imprimos por pantalla las caracteristicas del registro
				System.out.println("codigo:" + busc.getIdauto() +
								   " color :" + busc.getColor() + 
								   " modelo :" + busc.getModelo() + 
								   " motor :" + busc.getMotor() + 
								   " precio :" + busc.getPrecio() +
								   " marca :" + busc.getMarca() + 
								   " año de fabricacion :" + busc.getFabricacion());
				}
				
				//confirmamos
				emanager.getTransaction().commit();
				
				//cerramos
				emanager.close();
				
				//salimos del caso
				break;
				
		case "Listar":
			//en jdbc select * from tbl_auto aut---
			//en JPQL select a from TblAuto a entonces la programacion en eclipse es con las entidades 
			List<TblAuto> listado = emanager.createQuery("select a from TblAuto a", TblAuto.class).getResultList();
			
			//mostramos los datos por consola
			for (TblAuto list:listado){
				//imprimimos dentro del bucle
				System.out.println("codigo: " + list.getIdauto() + 
								   " color: " + list.getColor() + 
								   " modelo: " + list.getModelo() + 
								   " motor: " + list.getMotor() + 
								   " precio: " + list.getPrecio() + 
								   " marca: " + list.getMarca() + 
								   " fabricacion: " + list.getFabricacion());
			}//fin del bucle for
			
			//confirmamos
			emanager.getTransaction().commit();
			
			//cerramos
			emanager.close();
			
			//salimos del caso
			break;
			
			//otra forma de eliminar
		case "EliminarII":
			//eliminamos el codigo 3
			TblAuto elimII = emanager.find(TblAuto.class, 3);
			//aplicamos una condicion
			if(elimII==null){
				//emitimos un mensaje por consola
				System.out.println("El codigo no existe en la DB!!!");
			}else{
				//emitimos un mensaje por consola
				System.out.println("Registro encontrado");
				
				//eliminamos el registro
				emanager.remove(elimII);
				
				//confirmamos
				emanager.getTransaction().commit();
				
				//salimos
				emanager.close();
				
				//emitimos un mensaje por consola
				System.out.println("Codigo eliminado de la DB!!!");
			}//fin del ese
			
			//salimos del case
			break;
									
			default:
				System.out.println("Accion " + accion + " no encontrada");
			
		}//fin del switch
		

	} //fin del metodo principal

} //fin de la clase
