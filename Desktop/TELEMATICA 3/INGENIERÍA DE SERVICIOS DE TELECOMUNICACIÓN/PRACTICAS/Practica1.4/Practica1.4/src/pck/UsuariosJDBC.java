package pck;


import java.sql.*;
import java.util.ArrayList;
// JDBC (Java Database Connectivity) permite conectarnos con 
//base de datos SQL y ejecutar sentencias.
public class UsuariosJDBC implements DAOUsuarios {
	
	private String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private String URL_MYSQL = "jdbc:mysql://localhost:3306/ingserviciosp1";//Mirar nombre bbbbd
	private Connection conn;
	
	
	
	public UsuariosJDBC(){
	loadDriver();
	}
	
	
	//Clase para cargar el driver
	public void loadDriver(){
	try {
	Class.forName(DRIVER_MYSQL);
	} catch (ClassNotFoundException e) { 
		e.printStackTrace();
		} 
	}
	//Clase para establecer conexion
	public void getConnect(){
		try {
		conn = DriverManager.getConnection(URL_MYSQL,"root","");
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	// Implementación de métodos declarados en el interface:
	
//Metodo que muestra los usuarios
	public ArrayList<DTOUsuarios> muestraUser() {
		getConnect();
		String sql = "SELECT * FROM usuarios";
		String nombre,apellidos,email;
		
		ArrayList<DTOUsuarios> listout = new ArrayList<DTOUsuarios>();
		Statement stm = null;
		ResultSet rs = null;
		try{
		stm = conn.createStatement();
		rs = stm.executeQuery(sql);
		while (rs.next()){
		nombre=rs.getString("Nombre");
		apellidos=rs.getString("Apellidos");
		email=rs.getString("Email");
		DTOUsuarios us= new DTOUsuarios(nombre,apellidos,email);
		listout.add(us);
		
		}
		} catch(SQLException e){
			System.out.println(e);
		}
		finally{ 
			if (stm!=null) {
				try{ stm.close(); } catch(SQLException e){e.printStackTrace();}
				}
				if (conn!=null) {
				try{ conn.close(); } catch(SQLException e){e.printStackTrace(); }
				}
			
	        
}
		return listout;
		}
	
	//Insertar usuarios
	public void addUser(String name,String surname,String email) {
		getConnect();
		String sql="INSERT INTO usuarios (Nombre, Apellidos, Email)"
				+ " VALUES ('"+name+"','"+surname+"','"+email+"');";
		PreparedStatement stmt = null;
		try {
		stmt = conn.prepareStatement(sql);
		//Si el método de acceso a la base de datos tiene parámetros de entrada,
		//entonces se recomienda el uso de PreparedStatement en lugar de
		//Statement
		stmt.setString(1,name);
		stmt.setString(2,surname);
		stmt.setString(3,email);
		
		
		stmt.execute();// para operaciones de cualquier tipo, sin devolver objeto
		//ResultSet: INSERT,UPDATE, DELETE…
		}catch (Exception e) { System.out.println(e); }
		finally{
			if (stmt!=null) {
				try{ stmt.close(); } catch(SQLException e){e.printStackTrace();}
			}
			if (conn!=null) {
				try{ conn.close(); } catch(SQLException e){e.printStackTrace(); }
			}
		}
	}
}
