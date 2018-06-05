package multi;

import acceso_datos.Conector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SesionMulti
{
    public SesionMulti()
    {
        
    }

    public int validarSesion(String nombreUsuario, String claveAcceso)
    {
        String sqlQuery = String.format("SELECT id_usuario FROM tusuarios " + 
        		"WHERE correo_electronico = '%s' AND clave = '%s'", nombreUsuario, claveAcceso);
        ResultSet dato = null;
        int idUsuario = 0;
        try
        {
            dato = Conector.getConector().ejecutarSQL(sqlQuery);
            
            if(dato.next()) idUsuario = dato.getInt("id_usuario");
            
            Conector.getConector().finalizarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(SesionMulti.class.getName()).log(Level.SEVERE, null, ex);}
        
        return idUsuario;
    }
    
    public ArrayList<Integer> obtenerRolesUsuario(Integer idUsuario)
    {
        String sqlQuery = String.format("obtener_roles_usuario %d", idUsuario);
        ResultSet datos = null;
        ArrayList<Integer> roles = new ArrayList<>();
        try
        {
            datos = Conector.getConector().ejecutarSQL(sqlQuery);
            
            if(datos.next()) 
            	roles.add(datos.getInt("id_rol_en_departamento"));     
            
            Conector.getConector().finalizarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(SesionMulti.class.getName()).log(Level.SEVERE, null, ex);}
        
        return roles;
    }
}
