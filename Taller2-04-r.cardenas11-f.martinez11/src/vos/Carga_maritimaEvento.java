package vos;

import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Carga_maritimaEvento {

	@JsonProperty(value="ID_OPERACION")
	int ID_OPERACION;
	
	@JsonProperty(value="ID_CARGA_MARITIMA")
	int ID_CARGA_MARITIMA;
	
	@JsonProperty(value="ID_MUELLE")
	int ID_MUELLE;
	
	@JsonProperty(value="ID_CARGA")
	int ID_CARGA;
	
	@JsonProperty(value="ID_BUQUE")
	int ID_BUQUE;
	
	@JsonProperty(value="ID_EQUIPO_APOYO")
	int ID_EQUIPO_APOYO;
	
	@JsonProperty(value="FECHA")
	Date FECHA;
	
	@JsonProperty(value="HORA")
	Timestamp HORA;
	
	
	
	public Carga_maritimaEvento(@JsonProperty(value="ID_OPERACION")int iD_OPERACION,@JsonProperty(value="ID_CARGA_MARITIMA") int iD_CARGA_MARITIMA,@JsonProperty(value="ID_MUELLE") int iD_MUELLE,@JsonProperty(value="ID_CARGA") int iD_CARGA, @JsonProperty(value="ID_BUQUE")int iD_BUQUE,
			@JsonProperty(value="ID_EQUIPO_APOYO")int iD_EQUIPO_APOYO ,@JsonProperty(value="FECHA")Date pfecha , @JsonProperty(value="HORA") Timestamp phora) {
		super();
		ID_OPERACION = iD_OPERACION;
		ID_CARGA_MARITIMA = iD_CARGA_MARITIMA;
		ID_MUELLE = iD_MUELLE;
		ID_CARGA = iD_CARGA;
		ID_BUQUE = iD_BUQUE;
		ID_EQUIPO_APOYO = iD_EQUIPO_APOYO;
		FECHA = pfecha;
		HORA = phora;
		
		
	}
	
	public int getID_OPERACION() {
		return ID_OPERACION;
	}
	public void setID_OPERACION(int iD_OPERACION) {
		ID_OPERACION = iD_OPERACION;
	}
	public int getID_CARGA_MARITIMA() {
		return ID_CARGA_MARITIMA;
	}
	public void setID_CARGA_MARITIMA(int iD_CARGA_MARITIMA) {
		ID_CARGA_MARITIMA = iD_CARGA_MARITIMA;
	}
	public int getID_MUELLE() {
		return ID_MUELLE;
	}
	public void setID_MUELLE(int iD_MUELLE) {
		ID_MUELLE = iD_MUELLE;
	}
	public int getID_CARGA() {
		return ID_CARGA;
	}
	public void setID_CARGA(int iD_CARGA) {
		ID_CARGA = iD_CARGA;
	}
	public int getID_BUQUE() {
		return ID_BUQUE;
	}
	public void setID_BUQUE(int iD_BUQUE) {
		ID_BUQUE = iD_BUQUE;
	}
	public int getID_EQUIPO_APOYO() {
		return ID_EQUIPO_APOYO;
	}
	public void setID_EQUIPO_APOYO(int iD_EQUIPO_APOYO) {
		ID_EQUIPO_APOYO = iD_EQUIPO_APOYO;
	}
	

}
