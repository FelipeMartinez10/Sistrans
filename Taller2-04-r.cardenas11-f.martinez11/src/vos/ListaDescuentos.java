package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaDescuentos
{
	@JsonProperty(value="descuentos")
	private List<Descuento> descuentos;
	

	public ListaDescuentos( @JsonProperty(value="descuentos")List<Descuento> descuentos){
		this.descuentos = descuentos;
	}

	
	public List<Descuento> getDescuentos() {
		return descuentos;
	}

	
	public void setDescuentos(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}
}
