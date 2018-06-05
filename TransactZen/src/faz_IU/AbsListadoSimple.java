package faz_IU;

import java.net.URL;
import java.util.ResourceBundle;

import faz_modelo.FazListable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class AbsListadoSimple implements Initializable, IControlable, ISeleccionable
{
	private String nombreCosaListada;
	private ObservableList<FazListable> lista;
	private FilteredList<FazListable> listaFiltrada;
	private FazListable cosaSeleccionada;
	
	public AbsListadoSimple(String pcosaListada)
	{
		nombreCosaListada = pcosaListada;
		lista = FXCollections.observableArrayList();
	}
	
	@Override
	public void actualizarSeleccion(Object vector)
	{
		cosaSeleccionada = (FazListable) vector;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizarDato(Object vector)
	{
		lista = (ObservableList<FazListable>) vector;
	}

	@Override
	public void dormir()
	{
		lista.clear();
		cosaSeleccionada = null;
	}
	
    @FXML
    private Label lblCosaListada;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private ListView<FazListable> listViewCosa;

    @FXML
    private Button btnRegisCosa;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		lblCosaListada.setText(nombreCosaListada+"s");
		btnRegisCosa.setText("Registrar "+nombreCosaListada);
		
        if(!lista.isEmpty()) listViewCosa.setOnMouseClicked(event -> navegarDetalleLista());
        
        else lista.add(new FazListable("","No hay "+nombreCosaListada+"s"));

        listViewCosa.setCellFactory(param -> ponerStringAdapter());    
        listaFiltrada = new FilteredList<>(lista);
        listViewCosa.setItems(listaFiltrada);

        if(cosaSeleccionada != null)
        	listViewCosa.getSelectionModel().select(cosaSeleccionada);
        
        btnRegisCosa.setOnAction(event -> registrarCosa());
        txtFiltrar.setOnKeyPressed(filtrarLista());
	}
	
	public abstract void registrarCosa();
	
	public abstract void navegarDetalleLista();
	
	@Override
	public abstract void actualizarseDato();
	
    public ListCell<FazListable> ponerStringAdapter()
    {
        return new ListCell<FazListable>()
        {
            @Override
            protected void updateItem(FazListable item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty || item == null || item.getFace()== null)
                     setText("");
                
                else setText(item.getFace());
            }
        };
    }
    
    public EventHandler<KeyEvent> filtrarLista()
    {
        return new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent key)
            {
                if (key.getCode().equals(KeyCode.ENTER))
                {
                    String filter = txtFiltrar.getText(); 
                    
                    if(filter == null || filter.length() == 0)
                    	listaFiltrada.setPredicate(null); 
                    
                    else listaFiltrada.setPredicate
                        (fazListable -> fazListable.getFace().toLowerCase().contains(filter.toLowerCase()));
                }
            };
        };
    }
    
    public void setLista(ObservableList<FazListable> colexion)
    {
    	lista.setAll(colexion);
    }
}
