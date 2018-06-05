package faz_IU;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.stage.Window;

public class AbsValidador extends Tooltip
{
    Node vector;

    public AbsValidador() {
    } 

    public AbsValidador(Node pvector)
    {
        super();
        vector = pvector;
        vector . setOnKeyPressed(event -> hide());
        
        
        setAutoHide(true);
        setContentDisplay(ContentDisplay.BOTTOM);
    }
    
    public void ponerMensaje(String pmensaje)
    {
        setText(pmensaje);
        Window ventana = vector.getScene().getWindow();

        Point2D contexto = vector.localToScene(
            vector.getBoundsInLocal().getWidth(),
            vector.getBoundsInLocal().getHeight());
        
        show(ventana, contexto.getX() + ventana.getX(), contexto.getY() + ventana.getY());
    }
    
    public void quitarMensaje()
    {
        hide();
    }   
    
    public Node getNodo()
    {
        return vector;
    }

    public void setNodo(Node pvector)
    {
        vector = pvector;
    }
}
