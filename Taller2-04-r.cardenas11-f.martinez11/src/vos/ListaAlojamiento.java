package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAlojamiento 
{

	@JsonProperty(value="alojamiento")
	private List<Alojamineto_bodegaEvento> cargasMaritimas;
	
	
	public ListaAlojamiento( @JsonProperty(value="cargasMaritimas")List<Alojamineto_bodegaEvento> cargasMaritimas){
		this.cargasMaritimas = cargasMaritimas;
	}

	
	public List<Alojamineto_bodegaEvento> getBuque() {
		return cargasMaritimas;
	}

	
	public void setBuque(List<Alojamineto_bodegaEvento> cargasMaritimas) {
		this.cargasMaritimas = cargasMaritimas;
	}
}
