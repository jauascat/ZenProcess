package faz_IU;

public interface IFormulable
{   
    public Object getDato();

    public void setDato(Object dato);
            
    public void inactivarEntradaModulo();
    
    public boolean validarModulo();
    
    public boolean validarDatoIngresado();
    
    public void ponerMensaje(String mensaje);
}
