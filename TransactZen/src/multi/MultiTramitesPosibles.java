package multi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import acceso_datos.Conector;

public class MultiTramitesPosibles
{
	public MultiTramitesPosibles()
	{
	
	}
	
	@SuppressWarnings("unchecked")
	public static String getTramitesPosibles()
	{
		String sqlQuery = String.format("obtener_tramites_posibles");
        ResultSet datos = null;			
        JSONArray listaTramites = new JSONArray();
        try
        {
            datos = Conector.getConector().ejecutarSQL(sqlQuery);
            JSONObject rol = new JSONObject();
            if(datos.next())
            {
            	rol.put("idem", new String(datos.getString("id_tramite")));
            	rol.put("face", new String(datos.getString("nombre")));
            	
            	listaTramites.add(rol);
            }
            Conector.getConector().finalizarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(SesionMulti.class.getName()).log(Level.SEVERE, null, ex);}

		return listaTramites.toString();
	}
}
