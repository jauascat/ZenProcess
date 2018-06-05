package faz_IU;

import faz_modelo.ModeloListables;

public class TrolTramitesListar extends AbsListadoSimple
{
	TrolTramitesListar()
	{
		super("Tramite");
	}

	@Override
	public void registrarCosa()
	{
		TrolMainAdmin.control.ponerPop(TrolMainAdmin.TREGIS_BASICO);
	}

	@Override
	public void navegarDetalleLista()
	{
		
	}

	@Override
	public void actualizarseDato()
	{
		setLista(ModeloListables.getListaListables(TrolMainAdmin.gestor.getTramitesPosibles()));  
	}
}
