package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaReq10
{
	@JsonProperty(value="req10")
	private List<Req10> req10;
	
	
	public ListaReq10( @JsonProperty(value="req10")List<Req10> llegadas){
		this.req10 = llegadas;
	}

	
	public List<Req10> getLLegada() {
		return req10;
	}

	
	public void setLLegada(List<Req10> llegadas) {
		this.req10 = llegadas;
	}

}
