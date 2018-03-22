package pck;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String idSesion="";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		String nombre = request.getParameter("Nombre");
		String apellido = request.getParameter("Apellidos");
		String email = request.getParameter("Email");
		
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("email",email);
		
		String url="";
		 //Creamos objeto Usuarios jdbc, dtusuario
		UsuariosJDBC jdbc = new UsuariosJDBC();		 
		jdbc.addUser(nombre, apellido, email);
			 
	        	url="/WEB-INF/DatosRegistro.jsp";
     			
     	
 		
     	

			
	
		
		getServletContext().getRequestDispatcher(url).forward(request, response);

				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}