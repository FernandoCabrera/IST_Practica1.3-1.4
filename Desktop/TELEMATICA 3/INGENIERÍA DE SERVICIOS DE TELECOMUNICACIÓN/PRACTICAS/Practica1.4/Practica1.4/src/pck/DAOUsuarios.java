package pck;

import java.sql.SQLException;
import java.util.ArrayList;

//se recomienda organizar el acceso a una base de datos en
//componentes llamados DAOs (Objeto de Acceso a Datos)
public interface DAOUsuarios {
	public void  loadDriver();
	public void getConnect();
	public ArrayList<DTOUsuarios> muestraUser();
	public void addUser(String name,String surname,String email);
}
