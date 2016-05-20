package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Descuento 
{
	@JsonProperty(value="ID_EXPORTADOR")
	private String ID_EXPORTADOR;

	@JsonProperty(value="DESCUENTO")
	private String DESCUENTO;

	public Descuento(@JsonProperty(value="ID_EXPORTADOR")String idExpo,
			@JsonProperty(value="DESCUENTO")String descuento	)	
			
			{
				this.ID_EXPORTADOR= idExpo; 
				this.DESCUENTO = descuento;
			}

	public String getID_EXPORTADOR() {
		return ID_EXPORTADOR;
	}

	public void setID_EXPORTADOR(String iD_EXPORTADOR) {
		ID_EXPORTADOR = iD_EXPORTADOR;
	}

	public String getDESCUENTO() {
		return DESCUENTO;
	}

	public void setDESCUENTO(String dESCUENTO) {
		DESCUENTO = dESCUENTO;
	}
}
