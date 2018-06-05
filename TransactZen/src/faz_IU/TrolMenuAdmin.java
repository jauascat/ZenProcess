package faz_IU;

import java.net.URL;
import java.util.ResourceBundle;

import gestor.GestorAdmin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TrolMenuAdmin implements Initializable
{	
	public TrolMenuAdmin()
	{
		
	}

    @FXML
    private Button btnTramitesDisponibles;

    @FXML
    private Button btnTramitesCurso;

    @FXML
    private Button btnTramitesFinalizados;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Button btnRoles;

    @FXML
    private Button btnAreasFuncionales;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		btnTramitesDisponibles.setOnAction(e-> navegarLeft(TrolMainAdmin.TRAMITES));
		/*btnTramitesCurso.setOnAction      (e-> navegarIzquierda(TrolMainAdmin.MENU));
		btnTramitesFinalizados.setOnAction(e-> navegarIzquierda(TrolMainAdmin.MENU));
		btnUsuarios.setOnAction           (e-> navegarIzquierda(TrolMainAdmin.MENU));
		btnRoles.setOnAction              (e-> navegarIzquierda(TrolMainAdmin.MENU));
		btnAreasFuncionales.setOnAction   (e-> navegarIzquierda(TrolMainAdmin.MENU));*/
	}
	
	private void navegarLeft(Character vector)
	{
		TrolMainAdmin.control.navegarLeft(vector);
	}
}








