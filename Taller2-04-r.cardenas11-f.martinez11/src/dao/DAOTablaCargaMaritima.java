package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Carga;
import vos.Carga_maritima;

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

}
