package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaLLegadas {
	
	@JsonProperty(value="llegadas")
	private List<LLegada> salidas;
	
	
	public ListaLLegadas( @JsonProperty(value="llegadas")List<LLegada> llegadas){
		this.salidas = llegadas;
	}

	
	public List<LLegada> getLLegada() {
		return salidas;
	}

	
	public void setLLegada(List<LLegada> llegadas) {
		this.salidas = llegadas;
	}

}
