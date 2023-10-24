package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudAutoImp;
import Dao.ClassCrudEmpleadoImp;
import model.TblAuto;

/**
 * Servlet implementation class ControladorServlet
 */
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }//fin del constructor

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/GestionAuto.jsp").forward(request, response);
		
	}//fin del metodo get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//recuperamos los valores del formulario que ingresa el usuario final
		
		String color = request.getParameter("color");
		String modelo = request.getParameter("modelo");
		String motor = request.getParameter("motor");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String marca = request.getParameter("marca");
		String fabri = request.getParameter("fabricacion");
		
		//instanciamos las respectivas clases
		TblAuto tblauto = new TblAuto();
		ClassCrudAutoImp crud = new ClassCrudAutoImp();
		
		//asignamos los respectivos valores
		tblauto.setColor(color);
		tblauto.setModelo(modelo);
		tblauto.setMotor(motor);
		tblauto.setPrecio(precio);
		tblauto.setMarca(marca);
		tblauto.setFabricacion(fabri);
		
		//invocamos al metodo registrar
		crud.RegistrarAuto(tblauto);
		
		//recuperamos el listado de autos
		List<TblAuto> listadoauto = crud.ListadoAuto();
		
		request.setAttribute("listado", listadoauto);
		
		request.getRequestDispatcher("/GestionAuto.jsp").forward(request, response);
		
		
	}//fin del metodo post

}
