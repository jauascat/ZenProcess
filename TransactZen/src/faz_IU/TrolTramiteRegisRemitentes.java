package faz_IU;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import faz_modelo.FazRolSelectable;
import faz_modelo.FazTramite;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

@SuppressWarnings("serial")
public class TrolTramiteRegisRemitentes extends AbsFormulario implements Initializable, IControlable, IPopable
{
	private Stage escenario;
	private FazTramite tramite;
	
	private static final Character ROLES = 'R';
	
	public TrolTramiteRegisRemitentes()
	{
		super();
	}

	@Override
	public void inyectarEscenario(Stage stage)
	{
		escenario = stage;
	}

	@Override
	public void actualizarDato(Object vector)
	{
		tramite = (FazTramite) vector;
	}

	@Override
	public void actualizarseDato()
	{
		
	}

	@Override
	public void dormir()
	{
		escenario = null;
		tramite = null;
	}
	
    @FXML
    private TableView<FazRolSelectable> tablaRoles;
    
    @FXML
    private TableColumn<FazRolSelectable, String> clmZona;

    @FXML
    private TableColumn<FazRolSelectable, String> clmRol;

    @FXML
    private Label labelZona;

    @FXML
    private ComboBox<FazZonaSelectable> selectZona;

    @FXML
    private ComboBox<FazRolSelectable> selectRol;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnQuitar;

    @FXML
    private Label labelRol;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnContinuar;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		clmZona.setCellValueFactory(new PropertyValueFactory<>("nombreZona"));
		clmRol.setCellValueFactory(new PropertyValueFactory<>("nombreRol"));
		setModulo(ROLES, new FMSelectRoles(tablaRoles, labelZona, selectZona, labelRol, selectRol, btnAgregar, btnQuitar));
		
		btnContinuar.setOnAction(event -> registrar());
		btnCancelar.setOnAction( event ->
		{
	        TrolMainAdmin.control.get(TrolMainAdmin.TREGIS_BASICO).getControlable().dormir();
	        escenario.close();
		});
	}
	
	@SuppressWarnings("unchecked")
	public void registrar()
	{
		if(validarFormulario())
		{
			tramite.setRolesRemitentes((ArrayList<FazRolSelectable>)getDato(ROLES));
			
			Ventana nextFormulario = TrolMainAdmin.control.get(TrolMainAdmin.TREGIS_BASICO);
			nextFormulario.getControlable().actualizarDato(tramite);
			nextFormulario.propagarPop(escenario);
		}
	}
}
