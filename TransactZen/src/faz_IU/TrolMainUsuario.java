package faz_IU;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import faz_modelo.FazUsuarioActivo;
import gestor.GestorUsuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TrolMainUsuario extends HashMap<Character , Ventana> implements Initializable, IPopable
{
    public static TrolMainUsuario control;
    	       public static Stage escenario;
       public static GestorUsuario gestor;
       public static FazUsuarioActivo usuario;
          public static BorderPane tablero;
    
    public final static Character MENU = 'a';
    
    public TrolMainUsuario(FazUsuarioActivo pusuario)
    {
        super();
        usuario = pusuario;
        control = this;
        gestor = new GestorUsuario();
        put(MENU, new Ventana("MenuUsuario.fxml", new TrolMenuUsuario()));
    }

    @Override
    public void inyectarEscenario(Stage stage)
    {
        escenario = stage;
    }
    
    @FXML
    private BorderPane pantalla;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    	tablero = pantalla;
        tablero.setTop(get(MENU).cargarNodo());
        //tablero.setLeft(get());
    }
}
