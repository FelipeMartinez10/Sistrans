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
import vos.Req9;

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

		String sql = "SELECT id_operacion ,id_muelle, id_carga,id_carga_maritima, id_buque, id_equipo_apoyo, hora, fecha FROM CARGAR_MARITIMA INNER JOIN EVENTO_PUERTO on CARGAR_MARITIMA.id_carga_maritima = EVENTO_PUERTO.id_evento";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println("Metodo darCargasMaritimas");
		while (rs.next()) {
			System.out.println("0");
			int a = Integer.parseInt(rs.getString("id_operacion"));
			int b = Integer.parseInt(rs.getString("id_carga_maritima"));
			int c = Integer.parseInt(rs.getString("id_muelle"));
			int d = Integer.parseInt(rs.getString("id_carga"));
			int e = Integer.parseInt(rs.getString("id_buque"));
			int f = Integer.parseInt(rs.getString("id_equipo_apoyo"));
			Date g = rs.getDate("fecha");
			Timestamp h = rs.getTimestamp("hora");
			
			cargarMaritimas.add(new Carga_maritimaEvento(a, b, c,d,e,f,g,h));
		}
		return cargarMaritimas;
	}
	
	public ArrayList<Carga_maritima> darCargasMaritimasID(int id_carga, int id_buque) throws SQLException, Exception {
		ArrayList<Carga_maritima> cargasMaritimas = new ArrayList<Carga_maritima>();

		String sql = "SELECT id_operacion ,id_muelle, id_carga,id_carga_maritima, id_buque, id_equipo_apoyo "
				+ "FROM CARGAR_MARITIMA WHERE "
				+ "ID_CARGA = " + id_carga
				+" AND ID_BUQUE = "+id_buque;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println("Metodo darCargasMaritimasID");
		while (rs.next()) {
			int a = Integer.parseInt(rs.getString("id_operacion"));
			int b = Integer.parseInt(rs.getString("id_carga_maritima"));
			int c = Integer.parseInt(rs.getString("id_muelle"));
			int d = Integer.parseInt(rs.getString("id_carga"));
			int e = Integer.parseInt(rs.getString("id_buque"));
			int f = Integer.parseInt(rs.getString("id_equipo_apoyo"));
			
			cargasMaritimas.add(new Carga_maritima(a, b, c,d,e,f));
		}
		return cargasMaritimas;
	}
	
	public ArrayList<Req9> darCargasMaritimasFiltradas(int valor, String tipo) throws SQLException, Exception {
		ArrayList<Req9> cargasMaritimas = new ArrayList<Req9>();

		String sql = " SELECT id_operacion ,id_muelle, id_carga,tipo,cantidad, id_carga_maritima, id_buque, id_equipo_apoyo, fecha FROM (SELECT id_operacion ,id_muelle, id_carga AS id,id_carga_maritima, id_buque, id_equipo_apoyo,  fecha FROM CARGAR_MARITIMA INNER JOIN EVENTO_PUERTO on CARGAR_MARITIMA.id_carga_maritima = EVENTO_PUERTO.id_evento)c INNER JOIN (Select ID_CARGA, TIPO ,cantidad from (SELECT ID_CARGA AS ID FROM EXPORTADOR )a INNER JOIN CARGA on a.ID= CARGA.ID_CARGA) b ON c.id=b.ID_CARGA WHERE CANTIDAD > "+valor+"  AND TIPO = " +"'" + tipo +"'";
		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int a = Integer.parseInt(rs.getString("id_operacion"));
			int b = Integer.parseInt(rs.getString("id_carga_maritima"));
			int c = Integer.parseInt(rs.getString("id_muelle"));
			int d = Integer.parseInt(rs.getString("id_carga"));
			int e = Integer.parseInt(rs.getString("id_buque"));
			int f = Integer.parseInt(rs.getString("id_equipo_apoyo"));
			String g = rs.getString("tipo");
			int h = Integer.parseInt(rs.getString("cantidad"));
			Date i = rs.getDate("fecha");
			
			cargasMaritimas.add(new Req9(a, b, c, d, e, f, i, g));
		}
		return cargasMaritimas;
	}
	
	

}
