package faz_IU;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import gestor.GestorAdmin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TrolMainAdmin extends HashMap<Character , Ventana> implements Initializable, IPopable
{
       public static TrolMainAdmin control;
		  	   public static Stage escenario;
		 public static GestorAdmin gestor;
		 	 public static Integer idAdmin;
		  public static BorderPane tablero;
		  
		  public static Character pantallaActivaLeft;
    
     		 public final static Character MENU = 'a';
     	 public final static Character TRAMITES = 'b';
    public final static Character TREGIS_BASICO = 'c';
    public final static Character TREGIS_REMITE = 'd';
    
    public TrolMainAdmin(Integer pidAdmin)
    {
        super();
        control = this;
        gestor = new GestorAdmin();
        idAdmin = pidAdmin;
        
        pantallaActivaLeft = TRAMITES;
        
        put(         MENU, new Ventana(              "MenuAdmin.fxml", new TrolMenuAdmin()));
        put(	 TRAMITES, new Ventana(    "ListadoSimple.fxml", new TrolTramitesListar()));
        put(TREGIS_BASICO, new Ventana("TramiteRegisBasico.fxml", new TrolTramiteRegisBasico()));
        put(TREGIS_REMITE, new Ventana("TramiteRegisRemitente.fxml", new TrolTramiteRegisRemitentes()));
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
        
        TrolMainAdmin.control.ponerPop(TrolMainAdmin.TREGIS_REMITE);
    }
    
    public void navegarLeft(Character frontview)
    {
    	guardarse();
    	tablero.setLeft(actualizarse(frontview).cargarNodo());
    }

    public void ponerPop(Character vector)
    {
    	guardarse(vector);
    	actualizarse(vector).cargarPop();
    }
    
    public void propagarPop(Character vector, Stage escenario)
    {
    	guardarse(vector);
    	actualizarse(vector).propagarPop(escenario);
    }
    
    public Ventana actualizarse(Character vector)
    {
    	Ventana ventana = get(vector);
    	ventana.getControlable().actualizarseDato();
    	
    	return ventana;
    }
    
    public void guardarse()
    {
    	Ventana ventana = get(pantallaActivaLeft);
    	ventana.getControlable().dormir();
    }
    
    public void guardarse(Character vector)
    {
    	Ventana ventana = get(vector);
    	ventana.getControlable().dormir();
    }
}
