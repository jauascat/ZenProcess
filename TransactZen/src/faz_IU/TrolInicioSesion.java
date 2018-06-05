package faz_IU;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import faz_modelo.FazUsuarioActivo;
import gestor.GestorSesion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TrolInicioSesion extends AbsFormulario implements Initializable, IPopable
{
    private Stage escenario;
    private GestorSesion gestor;
    
    public static final Character NOM = 'n';
    public static final Character CLV = 'c';
    
    public TrolInicioSesion()
    {
        super();
        gestor = new GestorSesion();
    }

    @Override
    public void inyectarEscenario(Stage stage)
    {
        escenario = stage;
    }
    
    @FXML
    private Label labelNombre;

    @FXML
    private Label labelClave;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtClave;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        labelNombre.setLabelFor(txtNombre);
        labelClave.setLabelFor(txtClave);

        setModulo(NOM, new FMTexto(txtNombre));
        setModulo(CLV, new FMTexto(txtClave));
        
        txtNombre.setText("jauria@gmail.com");
        txtClave.setText("1234");
        
        btnCancelar.setOnAction(event -> { escenario.close();});
        btnIniciar.setOnAction(event -> ingresarSesion());
    }
    
    private void ingresarSesion()
    {
    	ArrayList<Integer> roles = new ArrayList<>();
    	Ventana principal = null;
        if(validarFormulario())
        {
            IFormulable nombre = get(NOM);
            IFormulable clave = get(CLV);
            int idUsuario = gestor.validarSesion((String)nombre.getDato(),
            									 (String)clave.getDato());
            
            if(idUsuario == 0)
            {
                nombre.ponerMensaje("Los datos no concuerdan");
                clave.ponerMensaje("Los datos no concuerdan");
            }
            else
            {
            	roles = gestor.obtenerRolesUsuario(idUsuario);
            	if(roles.isEmpty())
            	{
            		principal = new Ventana
    				(
						"PrincipalAdmin.fxml",
						new TrolMainAdmin(idUsuario)
					);
                    principal.propagarPop(escenario);  
            	}
            	else
            	{
                    principal = new Ventana
            		(
                		"PrincipalUsuario.fxml",
                		new TrolMainUsuario(new FazUsuarioActivo(idUsuario, roles))
            		);
                    principal.propagarPop(escenario); 
            	}
            }
        }
    }
}
