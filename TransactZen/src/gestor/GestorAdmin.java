package gestor;

import multi.MultiRolSelectable;
import multi.MultiTramitesPosibles;

public class GestorAdmin
{    
    public GestorAdmin()
    {

    }
    
    public String getTramitesPosibles()
    {
    	return MultiTramitesPosibles.getTramitesPosibles();
    }
    
    
    public String getRoles()
    {
    	return MultiRolSelectable.getListaRolesSelectables();
    }
}
