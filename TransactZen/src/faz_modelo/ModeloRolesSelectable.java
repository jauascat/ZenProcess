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

public class ModeloRolesSelectable
{
	public ModeloRolesSelectable()
	{
		
	}
	
	public ObservableList<FazRolSelectable> getListaRolesSelectable(String jsonColexion)
	{
		ObservableList<FazRolSelectable> lista = FXCollections.observableArrayList();
		JSONParser parser = new JSONParser();
		JSONArray array;
		
		try
		{
			array = (JSONArray) parser.parse(jsonColexion);
			
			for(int i=0; i<array.size(); i++)
			{
				JSONObject objeto = (JSONObject)array.get(i);
				FazRolSelectable rolnuevo = new FazRolSelectable();
				
				rolnuevo.setIdentificacion((String)objeto.get("identificacion"));
				rolnuevo.setIdemZona      ((String)objeto.get("idemZona"));
				rolnuevo.setNombreZona	  ((String)objeto.get("nombreZona"));
				rolnuevo.setIdemRol	  	  ((String)objeto.get("idemRol"));
				rolnuevo.setNombreRol	  ((String)objeto.get("nombreRol"));
				
				System.out.println(rolnuevo.getNombreRol());
				System.out.println(rolnuevo.getNombreZona());
				
				lista.add(rolnuevo);
			}
			
		} catch (ParseException ex) {
			Logger.getLogger(SesionMulti.class.getName()).log(Level.SEVERE, null, ex);}
		
		return FXCollections.observableArrayList(lista); 
	}
}
