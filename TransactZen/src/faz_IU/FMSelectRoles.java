package faz_IU;

import faz_modelo.FazRolSelectable;
import faz_modelo.ModeloRolesSelectable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.util.StringConverter;

public class FMSelectRoles extends AbsFormulario implements IFormulable
{
	AbsValidador validador;

	FilteredList<FazRolSelectable> rolesFiltrados;
	ObservableList<FazZonaSelectable> zonas;
	
	private static final Character ZONAS = 'z';
	private static final Character ROLES = 'r';
	
	
	public FMSelectRoles(TableView<FazRolSelectable> ptablaRoles,
						 Label labelZona,
						 ComboBox<FazZonaSelectable> selectZona,
						 Label labelRol,
						 ComboBox<FazRolSelectable> selectRol,
						 Button btnAgregar,
						 Button btnQuitar)
	{
		super();
		validador = new AbsValidador(ptablaRoles);

		ModeloRolesSelectable modeloRoles = new ModeloRolesSelectable();
		roles = modeloRoles.getListaRolesSelectable(TrolMainAdmin.control.gestor.getRoles());

		labelZona.setLabelFor(selectZona);
		labelRol.setLabelFor(selectRol);
		
		System.out.println(roles.size());
		
		selectRol.setItems(roles);
		selectRol.setConverter(rolSelectableStringAdapter());
		
		
		//setModulo(ZONAS, new FMSelectZona());
	}

    public StringConverter<FazRolSelectable> rolSelectableStringAdapter()
    {
		return new StringConverter<FazRolSelectable>()
		{
		    @Override
		    public String toString(FazRolSelectable object) {
		        return object.getNombreRol();
		    }

		    @Override
		    public FazRolSelectable fromString(String string) {
		        return null;
		    }
		};
    }
	
	@Override
	public Object getDato()
	{
		return null;
	}

	@Override
	public void setDato(Object dato)
	{
       /* if(dato instanceof String)
            input.getSelectionModel().select(() dato);
        
        else
            inputCuenta.setItems((ObservableList<CuentaListable>)dato);*/

	}

	@Override
	public void inactivarEntradaModulo()
	{

	}

	@Override
	public boolean validarModulo()
	{
		return false;
	}

	@Override
	public boolean validarDatoIngresado()
	{
		return false;
	}

	@Override
	public void ponerMensaje(String mensaje)
	{
		
	}
}
