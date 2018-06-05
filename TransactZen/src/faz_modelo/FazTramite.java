package faz_modelo;

import java.util.ArrayList;

public class FazTramite
{
	private String nombre;
	private String descripcion;
	private ArrayList<FazRolSelectable> rolesRemitentes;
	private ArrayList<FazRolSelectable> rolesRecipientes;
	private boolean autoServicio;
	private ArrayList<FazFormularioAbstracto> formularios;
	
	public FazTramite()
	{
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public ArrayList<FazRolSelectable> getRolesRemitentes() {
		return rolesRemitentes;
	}

	public ArrayList<FazRolSelectable> getRolesRecipientes() {
		return rolesRecipientes;
	}

	public boolean isAutoServicio() {
		return autoServicio;
	}

	public ArrayList<FazFormularioAbstracto> getFormularios() {
		return formularios;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setRolesRemitentes(ArrayList<FazRolSelectable> rolesRemitentes) {
		this.rolesRemitentes = rolesRemitentes;
	}

	public void setRolesRecipientes(ArrayList<FazRolSelectable> rolesRecipientes) {
		this.rolesRecipientes = rolesRecipientes;
	}

	public void setAutoServicio(boolean autoServicio) {
		this.autoServicio = autoServicio;
	}

	public void setFormularios(ArrayList<FazFormularioAbstracto> formularios) {
		this.formularios = formularios;
	}
}
