package faz_IU;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class FMSelectZona extends FMSelectComboBox
{
	ComboBox<FazZonaSelectable> input;	
	ObservableList<FazZonaSelectable> opciones;
	
	public FMSelectZona(ComboBox<FazZonaSelectable> pvector, FilteredList<FazZonaSelectable> opciones)
	{
		super(pvector);
		input.setCellFactory(new Callback<ListView<FazZonaSelectable>, ListCell<FazZonaSelectable>>()
        {
            @Override
            public ListCell<FazZonaSelectable> call(ListView<FazZonaSelectable> listView)
            {
                return new ListCell<FazZonaSelectable>() {
                    @Override
                    protected void updateItem(FazZonaSelectable zona, boolean empty)
                    {
                        super.updateItem(zona, empty);
                        
                        if (zona == null || empty) setGraphic(null);
 
                        else setText(zona.getNombreZona()); 
                    }
                };
            }
        });
        input.setItems(opciones);
	}
}
