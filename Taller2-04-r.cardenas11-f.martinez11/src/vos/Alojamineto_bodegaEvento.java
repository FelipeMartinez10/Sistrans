package vos;

import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Alojamineto_bodegaEvento 
{
	@JsonProperty(value="ID_BODEGA")
	int ID_BODEGA;
	

	
	@JsonProperty(value="ID_CARGA")
	int ID_CARGA;
	

	@JsonProperty(value="FECHA")
	Date FECHA;
	
	@JsonProperty(value="HORA")
	Timestamp HORA;
	
	
	
	
	
	
	public Alojamineto_bodegaEvento(@JsonProperty(value="ID_BODEGA")int iD_BODEGA,
			 @JsonProperty(value="ID_CARGA")int iD_CARGA ,@JsonProperty(value="FECHA")Date pfecha , @JsonProperty(value="HORA") Timestamp phora) {
		super();
		ID_BODEGA = iD_BODEGA;
		
		ID_CARGA = iD_CARGA;
		FECHA = pfecha;
		HORA = phora;
	}






	public Date getFECHA() {
		return FECHA;
	}






	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}






	public Timestamp getHORA() {
		return HORA;
	}






	public void setHORA(Timestamp hORA) {
		HORA = hORA;
	}






	public int getID_BODEGA() {
		return ID_BODEGA;
	}






	public void setID_BODEGA(int iD_BODEGA) {
		ID_BODEGA = iD_BODEGA;
	}








	public int getID_CARGA() {
		return ID_CARGA;
	}






	public void setID_CARGA(int iD_CARGA) {
		ID_CARGA = iD_CARGA;
	}
	

	
	

}
