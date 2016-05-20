package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Descuento;


public class DAOTablaDescuentos

{
	private ArrayList<Object> recursos;
	private Connection conn;

	
	
	public DAOTablaDescuentos() 
	{
		
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


	public ArrayList<Descuento> darDescuentos() throws SQLException, Exception {
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();

		String sql = "SELECT * FROM DESCUENTOS";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next())
		{
			String id = rs.getString("ID_EXPORTADOR");
			String dto = rs.getString("DESCUENTO");
			
			Descuento deto = new Descuento(id, dto);
			descuentos.add(deto);
			
		}
		
		return descuentos;
	}
	
	public void addDescuento(String id,String dto) throws SQLException, Exception {

		String sql = "INSERT INTO DESCUENTOS (ID_EXPORTADOR, NOMBRE_EXPORTADOR, DESCUENTO) VALUES ('"+id+"', 'Exportador:"+ id +"', '"+dto+"')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}


}
