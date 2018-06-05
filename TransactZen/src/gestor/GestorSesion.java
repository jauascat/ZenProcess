package gestor;

import java.util.ArrayList;

import multi.SesionMulti;

public class GestorSesion
{
    public int validarSesion(String nombreUsuario, String claveAcceso)
    {
        SesionMulti validarSesion = new SesionMulti();
        return validarSesion.validarSesion(nombreUsuario, claveAcceso);
    }
    
    public ArrayList<Integer> obtenerRolesUsuario(Integer idUsuario)
    {
    	SesionMulti validarSesion = new SesionMulti();
    	return validarSesion.obtenerRolesUsuario(idUsuario);
    }
}
