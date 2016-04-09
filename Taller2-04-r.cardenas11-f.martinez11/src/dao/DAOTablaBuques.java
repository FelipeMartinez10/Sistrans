package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Buque;
import vos.Salida;


public class DAOTablaBuques {


	
	private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOTablaBuques() {
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


	
	public ArrayList<Buque> darBuques() throws SQLException, Exception {
		ArrayList<Buque> buques = new ArrayList<Buque>();

		String sql = "SELECT * FROM BUQUE";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id_buque = Integer.parseInt(rs.getString("ID_BUQUE"));
			String name = rs.getString("NOMBRE");
			String name_AGENTE_MARITIMO = rs.getString("NOMBRE_AGENTE_MARITIMO");
			String registro_capitania = rs.getString("REGISTRO_CAPITANIA");
			double capacidadTeus = Double.parseDouble(rs.getString("CAPACIDAD_TEUS"));
			String tipo = rs.getString("TIPO");
			buques.add(new Buque(id_buque, name, name_AGENTE_MARITIMO,registro_capitania,capacidadTeus,tipo));
		}
		return buques;
	}
	

	

}
