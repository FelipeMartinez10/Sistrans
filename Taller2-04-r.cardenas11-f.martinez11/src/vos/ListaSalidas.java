package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaSalidas {

	@JsonProperty(value="salidas")
	private List<Salida> salidas;
	
	
	public ListaSalidas( @JsonProperty(value="salidas")List<Salida> salidas){
		this.salidas = salidas;
	}

	
	public List<Salida> getSalida() {
		return salidas;
	}

	
	public void setSalida(List<Salida> buques) {
		this.salidas = buques;
	}
	

}
