package faz_IU;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class FMSelectComboBox extends AbsValidador implements IFormulable
{
    ComboBox<?> input;
    
    public FMSelectComboBox(ComboBox<?> pvector)
    {
        super(pvector);
        input = pvector;
    }
    
    @Override
    public Object getDato()
    {
        return input.getValue();
    }

    @SuppressWarnings("unchecked")
	@Override
    public void setDato(Object dato)
    {
    	// no tiene
    }

    @Override
    public void inactivarEntradaModulo()
    {
        input.setDisable(true);
    }

    @Override
    public boolean validarModulo()
    {
        return validarDatoIngresado();
    }

    @Override
    public boolean validarDatoIngresado()
    {
        if(getDato() == null )
        {
            ponerMensaje("Este dato debe ser registrado");
            return false;
            
        } else
            {
                quitarMensaje();
                return true;   
            }        
    }

}
