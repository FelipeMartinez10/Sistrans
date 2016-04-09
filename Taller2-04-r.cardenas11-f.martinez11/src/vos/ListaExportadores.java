package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaExportadores {
	
	@JsonProperty(value="exportadores")
	private List<Exportador> export;
	
	
	public ListaExportadores( @JsonProperty(value="exportadores")List<Exportador> exportadores){
		this.export = exportadores;
	}

	
	public List<Exportador> getExportador() {
		return export;
	}

	
	public void setExportador(List<Exportador> exportadores) {
		this.export = exportadores;
	}
}
