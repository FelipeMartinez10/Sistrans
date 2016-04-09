package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Salida 
{
	@JsonProperty(value="id_salida")
	private int id_salida;
	
	@JsonProperty(value="id_muelle")
	private int id_muelle ;
	
	@JsonProperty(value="id_buque")
	private int id_buque ;
	
	
	
	
	
	public Salida(@JsonProperty(value="id_salida")int id,@JsonProperty(value="id_muelle")int id_muelleP,@JsonProperty(value="id_buque")int id_buqueP)
	{
		id_salida = id;
		id_muelle = id_muelleP;
		id_buque = id_buqueP;
	}
	

	public int getId_salida() {
		return id_salida;
	}

	public void setId_salida(int id_salida) {
		this.id_salida = id_salida;
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
