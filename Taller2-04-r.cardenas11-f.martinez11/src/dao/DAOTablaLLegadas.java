package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.LLegada;
import vos.Req7;
import vos.Salida;

public class DAOTablaLLegadas 
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
	public DAOTablaLLegadas() {
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
	
	
	
	public void updateBuqueLLegada(LLegada llegada) throws SQLException, Exception {

		String sql = "UPDATE LLEGADA SET ";
		sql += "ID_MUELLE='" + llegada.getInt_muelle() + "',";
		sql += "ID_BUQUE=" + llegada.getInt_buque();
		sql += " WHERE ID_LLEGADA = " + llegada.getId_llegada();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public ArrayList<LLegada> darLLegadass() throws SQLException, Exception 
	{
		ArrayList<LLegada> llegadas = new ArrayList<LLegada>();

		String sql = "SELECT * FROM LLEGADA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			int id_llegada = Integer.parseInt(rs.getString("ID_LLEGADA"));
			int id_muelle = Integer.parseInt(rs.getString("ID_MUELLE"));
			int id_buque = Integer.parseInt(rs.getString("ID_BUQUE"));
			llegadas.add(new LLegada(id_llegada, id_muelle, id_buque));
		}
		return llegadas;
	
	}
	
	public ArrayList<Req7> darLLegadasFiltradas(String fecha1, String fecha2, String nombre, String tipo) throws SQLException, Exception 
	{
		ArrayList<Req7> salidas = new ArrayList<Req7>();
		String f1 = fecha1.replace("-", "/");
		String f2 = fecha2.replace("-", "/");
		
		
		String sql = "SELECT id_buque,NOMBRE ,FECHA, TIPO FROM( SELECT id_buque AS id,FECHA FROM LLEGADA INNER JOIN EVENTO_PUERTO on LLEGADA.ID_EVENTO = EVENTO_PUERTO.id_evento)  g INNER JOIN BUQUE on g.id = BUQUE.ID_BUQUE WHERE FECHA > '"+ f1 +"' AND  FECHA < '" + f2 +"' AND NOMBRE = '" + nombre + "' AND TIPO = '" + tipo + "'";
		
		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		System.out.println("entro1");
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println("entro2");

		while (rs.next()) {
			
			
			int id_buque = Integer.parseInt(rs.getString("ID_BUQUE"));
			String nombree =  rs.getString("NOMBRE");
			Date fechaa =  rs.getDate("FECHA");
			String tipoo =  rs.getString("TIPO");
			salidas.add(new Req7(tipoo, id_buque, fechaa, nombree));
		}
		return salidas;
	
	}
	public ArrayList<Req7> darLLegadasFiltradas2(String fecha1, String fecha2, String nombre, String tipo) throws SQLException, Exception 
	{
		ArrayList<Req7> salidas = new ArrayList<Req7>();
		String f1 = fecha1.replace("-", "/");
		String f2 = fecha2.replace("-", "/");
		String sql = "SELECT id_buque,NOMBRE ,FECHA, TIPO FROM( SELECT id_buque AS id,FECHA FROM LLEGADA INNER JOIN EVENTO_PUERTO on LLEGADA.ID_EVENTO = EVENTO_PUERTO.id_evento)  g INNER JOIN BUQUE on g.id = BUQUE.ID_BUQUE WHERE FECHA > '"+ f1 +"' AND  FECHA < '" + f2 +"' AND NOMBRE <> '" + nombre + "' AND TIPO <> '" + tipo + "'";
		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		System.out.println("entro1");
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println("entro2");
		int i=0;
		while (rs.next() && i!=1000) {
			
			i++;
			int id_buque = Integer.parseInt(rs.getString("ID_BUQUE"));
			String nombree =  rs.getString("NOMBRE");
			Date fechaa =  rs.getDate("FECHA");
			String tipoo =  rs.getString("TIPO");
			salidas.add(new Req7(tipoo, id_buque, fechaa, nombree));
		}
		return salidas;
	
	}


}
