package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCargar_maritima 
{

	@JsonProperty(value="cargasMaritimas")
	private List<Carga_maritimaEvento> cargasMaritimas;
	
	
	public ListaCargar_maritima( @JsonProperty(value="cargasMaritimas")List<Carga_maritimaEvento> cargasMaritimas){
		this.cargasMaritimas = cargasMaritimas;
	}

	
	public List<Carga_maritimaEvento> getBuque() {
		return cargasMaritimas;
	}

	
	public void setBuque(List<Carga_maritimaEvento> cargasMaritimas) {
		this.cargasMaritimas = cargasMaritimas;
	}
}
