package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Buque;
import vos.Req7;
import vos.Salida;

public class DAOTablaSalidas 
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
	public DAOTablaSalidas() {
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
	
	
	
	public void updateBuqueSalida(Salida buque) throws SQLException, Exception {

		String sql = "UPDATE SALIDA SET ";
		sql += "ID_MUELLE='" + buque.getInt_muelle() + "',";
		sql += "ID_BUQUE=" + buque.getInt_buque();
		sql += " WHERE ID_SALIDA_MUELLE = " + buque.getId_salida();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public ArrayList<Salida> darSalidas() throws SQLException, Exception 
	{
		ArrayList<Salida> salidas = new ArrayList<Salida>();

		String sql = "SELECT * FROM SALIDA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			int id_salida = Integer.parseInt(rs.getString("ID_SALIDA_MUELLE"));
			int id_muelle = Integer.parseInt(rs.getString("ID_MUELLE"));
			int id_buque = Integer.parseInt(rs.getString("ID_BUQUE"));
			salidas.add(new Salida(id_salida, id_muelle, id_buque));
		}
		return salidas;
	
	}
	
	public ArrayList<Req7> darSalidasFiltradas(String fecha1, String fecha2, String nombre, String tipo) throws SQLException, Exception 
	{
		ArrayList<Req7> salidas = new ArrayList<Req7>();

		String sql = "SELECT id_buque,NOMBRE ,FECHA, TIPO FROM( SELECT id_buque AS id,FECHA FROM SALIDA INNER JOIN EVENTO_PUERTO on SALIDA.ID_EVENTO = EVENTO_PUERTO.id_evento)  g INNER JOIN BUQUE on g.id = BUQUE.ID_BUQUE WHERE FECHA > "+ fecha1 +" AND  FECHA < " + fecha2 +" AND NOMBRE = " + nombre + " AND TIPO = " + tipo;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			
			int id_buque = Integer.parseInt(rs.getString("ID_BUQUE"));
			String nombree =  rs.getString("NOMBRE");
			Date fechaa =  rs.getDate("FECHA");
			String tipoo =  rs.getString("TIPO");
			salidas.add(new Req7(tipoo, id_buque, fechaa, nombree));
		}
		return salidas;
	
	}
	
	public ArrayList<Req7> darSalidasFiltradas2(String fecha1, String fecha2, String nombre, String tipo) throws SQLException, Exception 
	{
		ArrayList<Req7> salidas = new ArrayList<Req7>();

		String sql = "SELECT id_buque,NOMBRE ,FECHA, TIPO FROM( SELECT id_buque AS id,FECHA FROM SALIDA INNER JOIN EVENTO_PUERTO on SALIDA.ID_EVENTO = EVENTO_PUERTO.id_evento)  g INNER JOIN BUQUE on g.id = BUQUE.ID_BUQUE WHERE FECHA > "+ fecha1 +" AND  FECHA < " + fecha2 +" AND NOMBRE <> " + nombre + " AND TIPO <> " + tipo;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			
			int id_buque = Integer.parseInt(rs.getString("ID_BUQUE"));
			String nombree =  rs.getString("NOMBRE");
			Date fechaa =  rs.getDate("FECHA");
			String tipoo =  rs.getString("TIPO");
			salidas.add(new Req7(tipoo, id_buque, fechaa, nombree));
		}
		return salidas;
	
	}

}
