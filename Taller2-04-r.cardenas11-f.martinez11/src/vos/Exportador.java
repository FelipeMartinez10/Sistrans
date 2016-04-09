package vos;

public class Exportador {
	
	String NOMBRE_EXPORTADOR;
	
	
	String PAIS;
	
	
	String PERSONA_CONTACTO;
	
	
	String CORREO;
	
	
	int ID_CARGA;


	public Exportador(String nOMBRE_EXPORTADOR, String pAIS, String pERSONA_CONTACTO, String cORREO, int iD_CARGA) {
		super();
		NOMBRE_EXPORTADOR = nOMBRE_EXPORTADOR;
		PAIS = pAIS;
		PERSONA_CONTACTO = pERSONA_CONTACTO;
		CORREO = cORREO;
		ID_CARGA = iD_CARGA;
	}


	public String getNOMBRE_EXPORTADOR() {
		return NOMBRE_EXPORTADOR;
	}


	public void setNOMBRE_EXPORTADOR(String nOMBRE_EXPORTADOR) {
		NOMBRE_EXPORTADOR = nOMBRE_EXPORTADOR;
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
