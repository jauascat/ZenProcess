package multi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import acceso_datos.Conector;

public class MultiRolSelectable
{
	public MultiRolSelectable()
	{
	
	}
	
	@SuppressWarnings("unchecked")
	public static String getListaRolesSelectables()
	{
		String sqlQuery = String.format("obtener_roles");
        ResultSet datos = null;			
        JSONArray listaRoles = new JSONArray();
        JSONObject rol = null;
        try
        {
            datos = Conector.getConector().ejecutarSQL(sqlQuery);
            while(datos.next())
            {
            	rol = new JSONObject();	
            	rol.put(  "identificacion", new String(datos.getString("id_rol_en_departamento")));
            	rol.put(        "idemZona", new String(datos.getString("id_departamento")));
            	rol.put(      "nombreZona", new String(datos.getString("nombreZona")));
            	rol.put(         "idemRol", new String(datos.getString("id_rol")));
            	rol.put(       "nombreRol", new String(datos.getString("nombreRol")));
            	
            	listaRoles.add(rol);
            }
            Conector.getConector().finalizarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(SesionMulti.class.getName()).log(Level.SEVERE, null, ex);}

		return listaRoles.toString();
	}
}
