package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import vos.Buque;
import vos.Carga;
import vos.Carga_maritima;
import vos.Carga_maritimaEvento;

public class DAOTablaCargaMaritima 
{
	
	private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOTablaCargaMaritima() {
		recursos = new ArrayList<Object>();
	}

	
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

	
	public void setConn(Connection con){
		this.conn = con;
	}

	
	
	public void updateCargaMaritima(Carga_maritima cargaMar) throws SQLException, Exception {

		String sql = "INSERT INTO CARGAR_MARITIMA VALUES (";
		sql += cargaMar.getID_OPERACION() + ",";
		sql += cargaMar.getID_CARGA_MARITIMA() + ",";
		sql += cargaMar.getID_MUELLE() + ",";
		sql += cargaMar.getID_CARGA() + ",";
		sql += cargaMar.getID_BUQUE() + ",";
		sql += cargaMar.getID_EQUIPO_APOYO() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	public void descargarCargaDeBarco(Carga_maritima cargaMar)throws SQLException, Exception
	{
		String sql = "DELETE FROM CARGAR_MARITIMA "
				+ "WHERE ID_BUQUE = "
				+cargaMar.getID_BUQUE()+" AND ID_CARGA = "+
				cargaMar.getID_CARGA();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void updateCarga(Carga cargaMar) throws SQLException, Exception {

		String sql = "INSERT INTO CARGAR VALUES (";
		sql += cargaMar.getID_CARGA() + ",";
		sql += cargaMar.getCANTIDAD() + ",";
		sql += cargaMar.getTIPO() + ",";
		sql += cargaMar.getESTADO() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	//FIXME
	public ArrayList<Carga_maritimaEvento> darCargasMaritimas() throws SQLException, Exception {
		ArrayList<Carga_maritimaEvento> cargarMaritimas = new ArrayList<Carga_maritimaEvento>();

		String sql = "SELECT id_muelle, id_carga, id_buque, id_equipo_apoyo, hora, fecha FROM CARGAR_MARITIMA INNER JOIN EVENTO_PUERTO on CARGAR_MARITIMA.id_carga_maritima = EVENTO_PUERTO.id_evento";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int a = Integer.parseInt(rs.getString("ID_OPERACION"));
			int b = Integer.parseInt(rs.getString("ID_CARGA_MARITIMA"));
			int c = Integer.parseInt(rs.getString("ID_MUELLE"));
			int d = Integer.parseInt(rs.getString("ID_CARGA"));
			int e = Integer.parseInt(rs.getString("ID_BUQUE"));
			int f = Integer.parseInt(rs.getString("ID_EQUIPO_APOYO"));
			Date g = rs.getDate("FECHA");
			Timestamp h = rs.getTimestamp("HORA");
			
			cargarMaritimas.add(new Carga_maritimaEvento(a, b, c,d,e,f,g,h));
		}
		return cargarMaritimas;
	}
	

}
