package faz_IU;

import javafx.beans.property.SimpleStringProperty;

public class FazZonaSelectable
{
	private String idemZona;
	private SimpleStringProperty nombreZona;
	
	
	public FazZonaSelectable()
	{
	
	}
	
	public String getIdemZona()
	{
		return idemZona;
	}
	
	public void setIdemZona(String idemZona)
	{
		this.idemZona = idemZona;
	}
	
	public String getNombreZona()
	{
		return nombreZona.get();
	}

	public void setNombreZona(String nombreZona)
	{
		this.nombreZona.set(nombreZona);
	}
}
