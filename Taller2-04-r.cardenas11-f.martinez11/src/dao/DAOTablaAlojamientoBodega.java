package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import vos.Alojamiento_bodega;
import vos.Alojamineto_bodegaEvento;
import vos.Bodega;
import vos.Buque;
import vos.Carga;
import vos.Carga_maritimaEvento;
import vos.Req10;
import vos.Salida;

public class DAOTablaAlojamientoBodega 
{

	/**
	 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Método constructor que crea DAOBuques
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOTablaAlojamientoBodega() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * Método que cierra todos los recursos que estan enel arreglo de recursos
	 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
	 */
	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	/**
	 * Método que inicializa la connection del DAO a la base de datos con la conexión que entra como parámetro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}
	
	
	
	public void registrarAlojamiento(Alojamiento_bodega pAloja) throws SQLException, Exception {

		String sql = "INSERT INTO ALOJAMIENTO_BODEGA VALUES (";
		sql += pAloja.getID_CARGA() + ",";
		sql += pAloja.getID_BODEGA() + ",";
		sql += pAloja.getID_EVENTO() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void eliminarCargaAlojada(int id) throws SQLException
	{
		//String sql = " DELETE FROM \"ISIS2304B041610\".\"ALOJAMIENTO_BODEGA\" WHERE ID_CARGA = "+id+"; " ;
		String sql = "DELETE FROM \"ISIS2304B041610\".\"ALOJAMIENTO_BODEGA\" WHERE ID_CARGA = 9" ;
		
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
	public ArrayList<Alojamineto_bodegaEvento> darAlojamiento() throws SQLException, Exception {
		ArrayList<Alojamineto_bodegaEvento> cargarMaritimas = new ArrayList<Alojamineto_bodegaEvento>();

		String sql = "SELECT id_bodega, id_carga,  hora, fecha FROM ALOJAMIENTO_BODEGA INNER JOIN EVENTO_PUERTO on ALOJAMIENTO_BODEGA.id_evento = EVENTO_PUERTO.id_evento";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println("watabitusberry queeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		while (rs.next()) {
			
			int a = Integer.parseInt(rs.getString("id_bodega"));
			int b = Integer.parseInt(rs.getString("id_carga"));
			Date g = rs.getDate("fecha");
			Timestamp h = rs.getTimestamp("hora");
			
			cargarMaritimas.add(new Alojamineto_bodegaEvento(a, b, g,h));
		}
		return cargarMaritimas;
	}
	

	public ArrayList<Req10> darAlojamientoFiltrado(int id) throws SQLException, Exception {
		ArrayList<Req10> cargarMaritimas = new ArrayList<Req10>();

		String sql = "SELECT id_bodega, id_carga,  fecha FROM ALOJAMIENTO_BODEGA INNER JOIN EVENTO_PUERTO on ALOJAMIENTO_BODEGA.id_evento = EVENTO_PUERTO.id_evento WHERE id = " + id;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			
			int a = Integer.parseInt(rs.getString("id_bodega"));
			int b = Integer.parseInt(rs.getString("id_carga"));
			Date g = rs.getDate("fecha");
			
			
			cargarMaritimas.add(new Req10(a, b, g));
		}
		return cargarMaritimas;
	}
	

}
