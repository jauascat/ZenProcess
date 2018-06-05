package faz_IU;

import javafx.scene.control.TextInputControl;

public class FMTexto extends AbsValidador implements IFormulable
{
    protected TextInputControl input;

    public FMTexto(TextInputControl pinput)
    {
        super(pinput);
        input = pinput;
    }

    @Override
    public Object getDato()
    {
        return input.getText().trim();
    }

    @Override
    public void setDato(Object dato)
    {
        input.setText((String) dato);
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
        if(getDato().toString().isEmpty())
        {
            ponerMensaje("Este dato es obligatorio registrar");
            return false;
            
        } else
        {
            quitarMensaje();
            return true;
        }
    }

    @Override
    public void ponerMensaje(String mensaje)
    {
        super.ponerMensaje(mensaje);
    }
}
