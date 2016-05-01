package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Req7 
{
	
	@JsonProperty(value="TIPO")
	private String tipo ;
	
	@JsonProperty(value="id_buque")
	private int id_buque ;
	
	@JsonProperty(value="FECHA")
	Date FECHA;
	
	@JsonProperty(value="NOMBRE")
	String NOMBRE;
	
	
	
	
	

	public Req7(@JsonProperty(value="TIPO")String tipo ,@JsonProperty(value="id_buque") int id_buque,@JsonProperty(value="FECHA") Date fECHA, @JsonProperty(value="NOMBRE")String nOMBRE)
	{
		super();
		this.tipo = tipo;
		this.id_buque = id_buque;
		FECHA = fECHA;
		NOMBRE = nOMBRE;
	}

	public String getId_muelle() {
		return tipo;
	}

	public void setId_muelle(String tipo) {
		this.tipo = tipo;
	}

	public int getId_buque() {
		return id_buque;
	}

	public void setId_buque(int id_buque) {
		this.id_buque = id_buque;
	}

	public Date getFECHA() {
		return FECHA;
	}

	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	
	
	

}
