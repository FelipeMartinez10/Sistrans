package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Alojamiento_bodega;
import vos.Bodega;
import vos.Buque;
import vos.Carga;
import vos.LLegada;
import vos.Salida;

public class DAOTablaBodega 
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
	public DAOTablaBodega() {
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
	
	
	
	public ArrayList<Bodega> getBodegasLibres() throws SQLException, Exception {

		ArrayList<Bodega> bodegasLibres = new ArrayList<Bodega>();

		String sql = "SELECT bod.* FROM "
				+ "ALOJAMIENTO_BODEGA aloj FULL OUTER JOIN BODEGA bod ON "
				+ "aloj.ID_BODEGA = bod.ID_BODEGA WHERE "
				+ "aloj.ID_BODEGA IS NULL";

		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			int id_bodega = Integer.parseInt(rs.getString("ID_BODEGA"));
			double ancho = Double.parseDouble(rs.getString("ANCHO"));
			double largo = Double.parseDouble(rs.getString("LARGO"));
			double separacion_columnas = Double.parseDouble(rs.getString("SEPARACION_COLUMNAS"));
			boolean plataforma_externa = rs.getString("PLATAFORMA_EXTERNA").equals("1");
			
			
			bodegasLibres.add(new Bodega(id_bodega, ancho, largo, separacion_columnas,plataforma_externa));
		}
		return bodegasLibres;
	}
	
	
	
	

}
