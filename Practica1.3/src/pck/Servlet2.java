package pck;

import java.io.IOException;

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
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {

			//Obtenemos la info de la respuesta
			String action=(request.getPathInfo()!=null?request.getPathInfo():"");
	        HttpSession misession = request.getSession();
	      
			
			//Creamos url
			String url="";
			//obtenemos el nombre
			String nombre = request.getParameter("nombre");
			misession.setAttribute("Nombre", nombre);
			//Añadimos a pa peticion
			request.setAttribute("Nombre", nombre);
			
			//obtenemos apellidos
			String apellidos = request.getParameter("apellidos");
			misession.setAttribute("Apellidos", apellidos);
			request.setAttribute("Apellido", apellidos);
			
			//Email
			String email = request.getParameter("email");
			misession.setAttribute("Email", email);
			request.setAttribute("Email", email);
			
		
			
	        //Tiempo de expiracion de la sesion
			misession.setMaxInactiveInterval(1000);
			//Si contiene out sesion invalida
	        if(action.equals("/out")){
	            misession.invalidate();
	            url="/WEB-INF/FormRegistro.html";
	        }else{
	        	
	        	url="/WEB-INF/DatosRegistro.jsp";	
	        }
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
