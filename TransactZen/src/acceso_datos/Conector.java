package acceso_datos;
 
public class Conector
{
	private static AccesoBD conectorBD;
	
	public static AccesoBD getConector() throws java.sql.SQLException
        {
            if(conectorBD == null) conectorBD = new AccesoBD();
            
            return conectorBD;
	}
}