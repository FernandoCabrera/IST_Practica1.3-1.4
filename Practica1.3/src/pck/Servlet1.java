package pck;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String user="admin";
	private static final String pass="admin";
	
	HttpSession sesion;

    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//url
		String url="index.html";
		String usu, password;
		
        usu = request.getParameter("user");
        password = request.getParameter("pass");
      
        //comprobamos que  usuario y pass sean correctos
        if(usu.equals(user) && password.equals(pass)  ){
            //si coincide usuario y password 
            //redirijo a jsp con información usuarios
        	 url="/WEB-INF/usuarios.jsp";
        	
            
        }else{
        	//Caso que no coincidan pasamos a FormRegistro html
        	//Aqui es donde se hace registro
        	 url="/WEB-INF/FormRegistro.html";
        	 
        }
    
        getServletContext().getRequestDispatcher(url).forward(request,response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
    	
    
	
    
	


