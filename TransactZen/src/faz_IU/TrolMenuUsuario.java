package faz_IU;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TrolMenuUsuario implements Initializable
{
	public TrolMenuUsuario()
	{
		
	}

    @FXML
    private Button btnIniciarTramite;

    @FXML
    private Button btnTramitesCurso;

    @FXML
    private Button btnVerTramitesFinalizados;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		btnIniciarTramite.setOnAction(e-> navegarIzquierda(TrolMainAdmin.MENU));
		btnTramitesCurso.setOnAction      (e-> navegarIzquierda(TrolMainAdmin.MENU));
		btnVerTramitesFinalizados.setOnAction(e-> navegarIzquierda(TrolMainAdmin.MENU));

	}
	
	private void navegarIzquierda(Character vector)
	{
		TrolMainUsuario.tablero.setLeft(TrolMainUsuario.control.get(vector).cargarNodo());
	}
}








