package faz_modelo;

import javafx.beans.property.SimpleStringProperty;

public class FazRolSelectable
{
	private String identificacion;
	private String idemZona;
	private SimpleStringProperty nombreZona;
	private String idemRol;
	private SimpleStringProperty nombreRol;
	
	public FazRolSelectable()
	{
		nombreZona = new SimpleStringProperty();
		nombreRol = new SimpleStringProperty();
	}

	public String getIdemZona()
	{
		return idemZona;
	}

	public String getIdemRol()
	{
		return idemRol;
	}
	
	public String getIdentificacion()
	{
		return identificacion;
	}

	public String getNombreRol()
	{
		return nombreRol.get();
	}
	
	public String getNombreZona()
	{
		return nombreZona.get();
	}

	public void setIdemZona(String idemZona)
	{
		this.idemZona = idemZona;
	}
	
	public void setIdentificacion(String identificacion)
	{
		this.identificacion = identificacion;
	}

	public void setIdemRol(String idemRol)
	{
		this.idemRol = idemRol;
	}

	public void setNombreRol(String nombreRol)
	{
		this.nombreRol.set(nombreRol);
	}
	
	public void setNombreZona(String nombreZona)
	{
		this.nombreZona.set(nombreZona);
	}
}
