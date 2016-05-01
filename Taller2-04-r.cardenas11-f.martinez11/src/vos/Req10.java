package vos;

import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Req10 
{

	@JsonProperty(value="ID_BODEGA")
	int ID_BODEGA;
	

	
	@JsonProperty(value="ID_CARGA")
	int ID_CARGA;
	

	@JsonProperty(value="FECHA")
	Date FECHA;
	

	
	
	
	
	
	
	public Req10(@JsonProperty(value="ID_BODEGA")int iD_BODEGA,
			 @JsonProperty(value="ID_CARGA")int iD_CARGA ,@JsonProperty(value="FECHA")Date pfecha ) {
		super();
		ID_BODEGA = iD_BODEGA;
		
		ID_CARGA = iD_CARGA;
		FECHA = pfecha;
		
	}






	public Date getFECHA() {
		return FECHA;
	}






	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
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
