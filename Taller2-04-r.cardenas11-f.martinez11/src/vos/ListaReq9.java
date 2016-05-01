package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaReq9 {

	@JsonProperty(value="req9")
	private List<Req9> req9;
	
	
	public ListaReq9( @JsonProperty(value="req9")List<Req9> llegadas){
		this.req9 = llegadas;
	}

	
	public List<Req9> getLLegada() {
		return req9;
	}

	
	public void setLLegada(List<Req9> llegadas) {
		this.req9 = llegadas;
	}

}
