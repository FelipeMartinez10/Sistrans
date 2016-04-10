package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBodegasLibres {
	
	@JsonProperty(value="bodegas")
	private List<Bodega> bodegas;
	
	
	public ListaBodegasLibres( @JsonProperty(value="bodegas")List<Bodega> bodegas){
		this.bodegas = bodegas;
	}

	
	public List<Bodega> getBodegas() {
		return bodegas;
	}

	
	public void setBodegas(List<Bodega> Bodegas) {
		this.bodegas = Bodegas;
	}

}
