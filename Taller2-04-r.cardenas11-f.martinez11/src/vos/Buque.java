package vos;

import org.codehaus.jackson.annotate.*;


public class Buque {

	//// Atributos

	@JsonProperty(value="id_buque")
	private int id_buque;
	
	@JsonProperty(value="name")
	private String name ;
	
	@JsonProperty(value="name_AGENTE_MARITIMO")
	private String name_AGENTE_MARITIMO ;
	
	@JsonProperty(value="registro_capitania")
	private String registro_capitania;
	
	@JsonProperty(value="capacidadTeus")
	private double capacidadTeus ;
	
	@JsonProperty(value="tipo")
	private String tipo;


	/**
	 * Método constructor de la clase buque
	 * <b>post: </b> Crea el buque
	 */
	public Buque(@JsonProperty(value="id_buque")int id, @JsonProperty(value="name")String name,@JsonProperty(value="name_AGENTE_MARITIMO") String agenteMartimo,@JsonProperty(value="registro_capitania") String registroCap,@JsonProperty(value="capacidadTeus")double capacidad,@JsonProperty(value="tipo")String ptipo) {
		super();
		id_buque = id;
		this.name = name;
		name_AGENTE_MARITIMO = agenteMartimo;
		registro_capitania= registroCap ;
		capacidadTeus= capacidad;
		tipo= tipo ;
	}

	public int getId_buque() {
		return id_buque;
	}

	public void setId_buque(int id_buque) {
		this.id_buque = id_buque;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_AGENTE_MARITIMO() {
		return name_AGENTE_MARITIMO;
	}

	public void setName_AGENTE_MARITIMO(String name_AGENTE_MARITIMO) {
		this.name_AGENTE_MARITIMO = name_AGENTE_MARITIMO;
	}

	public String getRegistro_capitania() {
		return registro_capitania;
	}

	public void setRegistro_capitania(String registro_capitania) {
		this.registro_capitania = registro_capitania;
	}

	public double getCapacidadTeus() {
		return capacidadTeus;
	}

	public void setCapacidadTeus(double capacidadTeus) {
		this.capacidadTeus = capacidadTeus;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	



}
