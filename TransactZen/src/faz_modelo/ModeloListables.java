package faz_modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import multi.SesionMulti;

public class ModeloListables
{
	public ModeloListables()
	{
		
	}
	
	public static ObservableList<FazListable> getListaListables(String jsonColexion)
	{
		ObservableList<FazListable> lista = FXCollections.observableArrayList();
		JSONParser parser = new JSONParser();
		JSONArray array;
		
		try
		{
			array = (JSONArray) parser.parse(jsonColexion);
			
			for(int i=0; i<array.size(); i++)
			{
				JSONObject objeto = (JSONObject)array.get(i);
				FazListable rolnuevo = new FazListable();
				
				rolnuevo.setIdem((String)objeto.get("idem"));
				rolnuevo.setFace((String)objeto.get("face"));
				
				lista.add(rolnuevo);
			}
			
		} catch (ParseException ex) {
			Logger.getLogger(SesionMulti.class.getName()).log(Level.SEVERE, null, ex);}
		
		return FXCollections.observableArrayList(lista); 
	}
}
