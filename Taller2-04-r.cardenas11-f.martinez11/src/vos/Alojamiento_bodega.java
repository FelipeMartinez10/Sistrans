package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Alojamiento_bodega {
	
	
	@JsonProperty(value="ID_BODEGA")
	int ID_BODEGA;
	
	@JsonProperty(value="ID_EVENTO")
	int ID_EVENTO;
	
	@JsonProperty(value="ID_CARGA")
	int ID_CARGA;
	
	
	
	
	
	
	public Alojamiento_bodega(@JsonProperty(value="ID_BODEGA")int iD_BODEGA,
			@JsonProperty(value="ID_EVENTO")int iD_EVENTO, @JsonProperty(value="ID_CARGA")int iD_CARGA) {
		super();
		ID_BODEGA = iD_BODEGA;
		ID_EVENTO = iD_EVENTO;
		ID_CARGA = iD_CARGA;
	}






	public int getID_BODEGA() {
		return ID_BODEGA;
	}






	public void setID_BODEGA(int iD_BODEGA) {
		ID_BODEGA = iD_BODEGA;
	}






	public int getID_EVENTO() {
		return ID_EVENTO;
	}






	public void setID_EVENTO(int iD_EVENTO) {
		ID_EVENTO = iD_EVENTO;
	}






	public int getID_CARGA() {
		return ID_CARGA;
	}






	public void setID_CARGA(int iD_CARGA) {
		ID_CARGA = iD_CARGA;
	}
	

	
	
}
