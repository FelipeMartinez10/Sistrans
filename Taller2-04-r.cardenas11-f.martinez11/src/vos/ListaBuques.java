/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: VideoAndes
 * Autor: Juan Felipe García - jf.garcia268@uniandes.edu.co
 * -------------------------------------------------------------------
 */
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa una arreglo de Video
 * @author Juan
 */
public class ListaBuques {
	
	
	@JsonProperty(value="buques")
	private List<Buque> buques;
	
	
	public ListaBuques( @JsonProperty(value="buques")List<Buque> buques){
		this.buques = buques;
	}

	
	public List<Buque> getBuque() {
		return buques;
	}

	
	public void setBuque(List<Buque> buques) {
		this.buques = buques;
	}
	
}
