package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class LLegada {
	@JsonProperty(value="id_llegada")
	private int id_llegada;
	
	@JsonProperty(value="id_muelle")
	private int id_muelle ;
	
	@JsonProperty(value="id_buque")
	private int id_buque ;
	
	
	
	
	
	public LLegada(@JsonProperty(value="id_llegada")int id,@JsonProperty(value="id_muelle")int id_muelleP,@JsonProperty(value="id_buque")int id_buqueP)
	{
		id_llegada = id;
		id_muelle = id_muelleP;
		id_buque = id_buqueP;
	}
	

	public int getId_llegada() {
		return id_llegada;
	}

	public void setId_salida(int id_salida) {
		this.id_llegada = id_llegada;
	}

	public int getInt_muelle() {
		return id_muelle;
	}

	public void setInt_muelle(int int_muelle) {
		this.id_muelle = int_muelle;
	}

	public int getInt_buque() {
		return id_buque;
	}

	public void setInt_buque(int int_buque) {
		this.id_buque = int_buque;
	}
	

}
