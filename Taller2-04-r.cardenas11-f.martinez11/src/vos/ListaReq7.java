package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaReq7 
{

	@JsonProperty(value="req7")
	private List<Req7> req7;
	
	
	public ListaReq7( @JsonProperty(value="req7")List<Req7> llegadas){
		this.req7 = llegadas;
	}

	
	public List<Req7> getLLegada() {
		return req7;
	}

	
	public void setLLegada(List<Req7> llegadas) {
		this.req7 = llegadas;
	}

}
