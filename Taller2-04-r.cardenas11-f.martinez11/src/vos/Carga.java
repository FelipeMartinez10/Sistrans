package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Carga {
	
	@JsonProperty(value="ID_CARGA")
	int ID_CARGA;
	
	@JsonProperty(value="CANTIDAD")
	double CANTIDAD;
	
	@JsonProperty(value="TIPO")
	String TIPO;
	
	@JsonProperty(value="ESTADO")
	char ESTADO;

	public Carga(int iD_CARGA, double cANTIDAD, String tIPO, char eSTADO) {
		super();
		ID_CARGA = iD_CARGA;
		CANTIDAD = cANTIDAD;
		TIPO = tIPO;
		ESTADO = eSTADO;
	}

	public int getID_CARGA() {
		return ID_CARGA;
	}

	public void setID_CARGA(int iD_CARGA) {
		ID_CARGA = iD_CARGA;
	}

	public double getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(double cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}

	public char getESTADO() {
		return ESTADO;
	}

	public void setESTADO(char eSTADO) {
		ESTADO = eSTADO;
	}
	
	
}
