package faz_modelo;

import java.util.ArrayList;

public class FazUsuarioActivo
{
	private int id_usuario;
	private ArrayList<Integer> rolesUsuario;

	public FazUsuarioActivo()
	{
		
	}
	
	public FazUsuarioActivo(int id_usuario, ArrayList<Integer> rolesUsuario)
	{
		this.id_usuario = id_usuario;
		this.rolesUsuario = rolesUsuario;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public ArrayList<Integer> getRolesUsuario() {
		return rolesUsuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setRolesUsuario(ArrayList<Integer> rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}
}
