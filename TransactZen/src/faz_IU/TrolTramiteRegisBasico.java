package faz_IU;

import java.net.URL;
import java.util.ResourceBundle;

import faz_modelo.FazTramite;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings("serial")
public class TrolTramiteRegisBasico extends AbsFormulario implements Initializable, IControlable, IPopable
{
	private Stage escenario;
	private FazTramite tramite;
	
	private static final Character NOMBR = 'n';
	private static final Character DSCRP = 'd';
	
	public TrolTramiteRegisBasico()
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
		tramite = new FazTramite();
	}

	@Override
	public void dormir()
	{
		escenario = null;
		tramite = null;
	}
	
    @FXML
    private Label labelNombre;

    @FXML
    private Label labelDescripcion;

    @FXML
    private TextField txtNombreTramite;

    @FXML
    private TextArea txtDescripTramite;

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnCancelar;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		labelNombre.setLabelFor(txtNombreTramite);
		labelDescripcion.setLabelFor(txtDescripTramite);
		
		setModulo(NOMBR, new FMTexto(txtNombreTramite));
		setModulo(DSCRP, new FMTexto(txtDescripTramite));
		
		btnContinuar.setOnAction(event -> registrar());
		btnCancelar.setOnAction( event ->
		{
	        TrolMainAdmin.control.get(TrolMainAdmin.TREGIS_BASICO).getControlable().dormir();
	        escenario.close();
		});
	}
	
	public void registrar()
	{
		if(validarFormulario())
		{
			tramite.setNombre     ((String)getDato(NOMBR));
			tramite.setDescripcion((String)getDato(DSCRP));
			
			TrolMainAdmin.control.propagarPop(TrolMainAdmin.TREGIS_REMITE, escenario);
		}
	}
}
