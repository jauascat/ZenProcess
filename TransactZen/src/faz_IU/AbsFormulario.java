package faz_IU;
    import java.util.HashMap;

public abstract class AbsFormulario extends HashMap <Character , IFormulable>
{
    public AbsFormulario()
    {
        super();
    }
    
    public boolean validarFormulario()
    {
    	return validarModulos();
    }
    
    public boolean validarModulos()
    {
        boolean bError = true;
        
        for(IFormulable modulo : values())

            if(!modulo.validarModulo()) 
                bError = false;

        return bError;
    }
    
    public void setModulo(Character vector, IFormulable modulo)
    {
        put(vector, modulo);
    }
    
    public void ponerModIficar(Character vector, Object dato)
    {
        get(vector).setDato(dato);
    }
    
    public void inactivarModulo(Character vector)
    {
        get(vector).inactivarEntradaModulo();
    }
       
    public boolean validarModulo(Character vector)
    {
        return get(vector).validarModulo();
    }
        
    public Object getDato(Character vector)
    {
        return get(vector).getDato();
    }
    
    public void borrarFormulario()
    {
        clear();
    }
}
