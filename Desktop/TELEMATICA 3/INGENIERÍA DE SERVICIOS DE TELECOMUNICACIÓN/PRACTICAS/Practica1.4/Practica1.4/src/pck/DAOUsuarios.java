package pck;

import java.util.ArrayList;

//se recomienda organizar el acceso a una base de datos en
//componentes llamados DAOs (Objeto de Acceso a Datos)
public interface DAOUsuarios {
	public ArrayList<DTOUsuarios> muestraUser();
	public void addUser(DTOUsuarios user,String name,String surname,String email);
}
