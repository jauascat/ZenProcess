package faz_IU;

import java.io.IOException;
import javafx.application.*;
import javafx.stage.*;

public class TrolAplicacion extends Application
{
    public static TrolInicioSesion inicio;
    
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        inicio = new TrolInicioSesion();
        
        Ventana ventana = new Ventana("InicioSesion.fxml", inicio);
        ventana.getPop().inyectarEscenario(primaryStage);
   
        primaryStage.setScene(ventana.cargarEscena());
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
    }
}
