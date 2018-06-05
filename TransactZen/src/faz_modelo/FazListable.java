package faz_modelo;

public class FazListable
{
	private String idem;
	private String face;
	
	public FazListable(String idem, String face) {
		super();
		this.idem = idem;
		this.face = face;
	}

	public FazListable()
	{
	
	}

	public String getIdem() {
		return idem;
	}

	public String getFace() {
		return face;
	}

	public void setIdem(String idem) {
		this.idem = idem;
	}

	public void setFace(String face) {
		this.face = face;
	}

}
