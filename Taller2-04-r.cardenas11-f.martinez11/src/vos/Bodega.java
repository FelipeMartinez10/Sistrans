package vos;

import org.codehaus.jackson.annotate.*;


public class Bodega {

	//// Atributos

	@JsonProperty(value="ID_BODEGA")
	private int ID_BODEGA;
	
	@JsonProperty(value="ANCHO")
	private double ANCHO ;
	
	@JsonProperty(value="LARGO")
	private double LARGO ;
	
	@JsonProperty(value="SEPARACION_COLUMNAS")
	private double SEPARACION_COLUMNAS;
	
	@JsonProperty(value="PLATAFORMA_EXTERNA")
	private boolean PLATAFORMA_EXTERNA ;
	
	


	
	public Bodega(@JsonProperty(value ="ID_BODEGA")int id_bodega, @JsonProperty(value ="ANCHO")double ancho
			, @JsonProperty(value ="LARGO")double largo, @JsonProperty(value ="SEPARACION_COLUMNAS")double separacion_columnas, 
			@JsonProperty(value ="PLATAFORMA_EXTERNA")boolean plataforma_externa) {
		super();
		this.ID_BODEGA = id_bodega;
		this.ANCHO = ancho;
		this.LARGO = largo;
		this.SEPARACION_COLUMNAS = separacion_columnas;
		this.PLATAFORMA_EXTERNA= plataforma_externa;
	}





	public int getID_BODEGA() {
		return ID_BODEGA;
	}





	public void setID_BODEGA(int iD_BODEGA) {
		ID_BODEGA = iD_BODEGA;
	}





	public double getANCHO() {
		return ANCHO;
	}





	public void setANCHO(double aNCHO) {
		ANCHO = aNCHO;
	}





	public double getLARGO() {
		return LARGO;
	}





	public void setLARGO(double lARGO) {
		LARGO = lARGO;
	}





	public double getSEPARACION_COLUMNAS() {
		return SEPARACION_COLUMNAS;
	}





	public void setSEPARACION_COLUMNAS(double sEPARACION_COLUMNAS) {
		SEPARACION_COLUMNAS = sEPARACION_COLUMNAS;
	}





	public boolean isPLATAFORMA_EXTERNA() {
		return PLATAFORMA_EXTERNA;
	}





	public void setPLATAFORMA_EXTERNA(boolean pLATAFORMA_EXTERNA) {
		PLATAFORMA_EXTERNA = pLATAFORMA_EXTERNA;
	}



	



}
