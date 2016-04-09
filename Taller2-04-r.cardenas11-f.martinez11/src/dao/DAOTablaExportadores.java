package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Buque;
import vos.Exportador;
import vos.Salida;

public class DAOTablaExportadores 
{
	private ArrayList<Object> recursos;

	
	private Connection conn;

	
	 public DAOTablaExportadores() {
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


	
	public ArrayList<Exportador> darExportador() throws SQLException, Exception {
		ArrayList<Exportador> exportadores = new ArrayList<Exportador>();

		String sql = "SELECT * FROM EXPORTADOR NATURAL JOIN CARGA ";
		
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id_carga = Integer.parseInt(rs.getString("ID_CARGA"));
			String nOMBRE_EXPORTADOR = rs.getString("NOMBRE_EXPORTADOR");
			String pAIS = rs.getString("PAIS");
			String cORREO = rs.getString("CORREO");
			String pERSONA_CONTACTO = rs.getString("PERSONA_CONTACTO");
			exportadores.add(new Exportador(nOMBRE_EXPORTADOR, pAIS, pERSONA_CONTACTO, cORREO, id_carga));
		}
		return exportadores;
	}

	

}
