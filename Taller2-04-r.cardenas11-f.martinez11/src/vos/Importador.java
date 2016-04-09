package vos;

public class Importador {

	String NOMBRE_IMPORTADOR;
	
	
	String PAIS;
	
	
	String PERSONA_CONTACTO;
	
	
	String CORREO;
	
	
	int ID_CARGA;


	 public Importador(String NOMBRE_IMPORTADOR, String pAIS, String pERSONA_CONTACTO, String cORREO, int iD_CARGA) {
		super();
		this.NOMBRE_IMPORTADOR = NOMBRE_IMPORTADOR;
		this.PAIS = pAIS;
		this.PERSONA_CONTACTO = pERSONA_CONTACTO;
		this.CORREO = cORREO;
		this.ID_CARGA = iD_CARGA;
	}


	public String getNOMBRE_IMPORTADOR() {
		return NOMBRE_IMPORTADOR;
	}


	public void setNOMBRE_IMPORTADOR(String nOMBRE_EXPORTADOR) {
		NOMBRE_IMPORTADOR = nOMBRE_EXPORTADOR;
	}


	public String getPAIS() {
		return PAIS;
	}


	public void setPAIS(String pAIS) {
		PAIS = pAIS;
	}


	public String getPERSONA_CONTACTO() {
		return PERSONA_CONTACTO;
	}


	public void setPERSONA_CONTACTO(String pERSONA_CONTACTO) {
		PERSONA_CONTACTO = pERSONA_CONTACTO;
	}


	public String getCORREO() {
		return CORREO;
	}


	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}


	public int getID_CARGA() {
		return ID_CARGA;
	}


	public void setID_CARGA(int iD_CARGA) {
		ID_CARGA = iD_CARGA;
	}
	
	

}
