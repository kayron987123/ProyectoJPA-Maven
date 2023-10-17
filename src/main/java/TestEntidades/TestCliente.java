package TestEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		//establecemos la conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");//viene de persistence.xml(persitence-unit name)
				
		//gestionar entidades como registrar,actualizar,eliminar,listar,buscar
		EntityManager emanager = conex.createEntityManager();
				
		//iniciamos transaccion (iniciar la operacion como el crud)
		emanager.getTransaction().begin();
		
		//instanciamos
		TblCliente cliente = new TblCliente();
		
		//creamos una variable de tipo string de nombre accion
		String accion=JOptionPane.showInputDialog("Ingrese la accion");
		
		//aplicamos el switch
		switch(accion){
		case "Registrar":
			cliente.setNombre("Patricia Evelyn");
			cliente.setApellido("Macedo");
			cliente.setEmail("Patricia@hotmail.com");
			cliente.setDni("48695712");
			cliente.setSexo("f");
			
			//registramos en la BD
			emanager.persist(cliente);
			
			//emitimos mensaje por consola
			System.out.println("Registrado en DB");
			
			//confirmamos la transaccion
			emanager.getTransaction().commit();
			
			//cerramos
			emanager.close();

			//salimos
			break;
			
		case "Actualizar":
			cliente.setIdcliente(1);
			cliente.setNombre("Marco Antonio");
			cliente.setApellido("Cardenas");
			cliente.setEmail("Marco@hotmail.com");
			cliente.setDni("6398745");
			cliente.setSexo("m");
			
			//actualizamos en la BD
			emanager.merge(cliente);
			
			//emitimos mensaje por consola
			System.out.println("Registro actualizado");
			
			//confirmamos la transaccion
			emanager.getTransaction().commit();
			
			//cerramos
			emanager.close();
			
			//salimos
			break;
			
		case "Eliminar":
			//salimos
			break;
			
		case "Buscar":
			//salimos
			break;
			
		case "Listar":
			//salimos
			break;
			
		case "EliminarII":
			//salimos
			break;
			
		default:
			//emitimos un mensaje
			System.out.println("Accion " + accion + " no encontrada");
		}//fin del switch
		

	}//fin del metodo principal

}//fin de la clase
