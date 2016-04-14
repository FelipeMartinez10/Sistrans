package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCargas_maritimaID 
{

	@JsonProperty(value="cargasMaritimas")
	private List<Carga_maritima> cargasMaritimas;
	
	
	public ListaCargas_maritimaID( @JsonProperty(value="cargasMaritimas")List<Carga_maritima> cargasMaritimas){
		this.cargasMaritimas = cargasMaritimas;
	}
	

	
	public List<Carga_maritima> getCargas() {
		return cargasMaritimas;
	}

	/*
	public void setBuque(List<Carga_maritima> cargasMaritimas) {
		this.cargasMaritimas = cargasMaritimas;
	}
	*/
}
