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
		
		//Para acceder a un jsp 
		String url="login.html";
		String usu, pass;
		
        usu = request.getParameter("user");
        pass = request.getParameter("password");
      
        //comprobamos que  usuario y pass sean correctos
        if(usu.equals("admin") && pass.equals("admin")  ){
            //si coincide usuario y password 
            //redirijo a página con información usuarios
        	 url="/WEB-INF/usuarios.jsp";
        	
            
        }else{
        	//Caso que no coincidan pasamos a index html
        	 url="index.html";
        	 
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
    	
    
	
    
	


