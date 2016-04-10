package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.DAOTablaBuques;
import dao.DAOTablaCargaMaritima;
import dao.DAOTablaExportadores;
import dao.DAOTablaLLegadas;
import dao.DAOTablaSalidas;
import vos.Buque;
import vos.Carga;
import vos.Carga_maritima;
import vos.Exportador;
import vos.ListaBuques;
import vos.ListaExportadores;
import vos.ListaLLegadas;
import vos.ListaSalidas;
import vos.Salida;
import vos.LLegada;


public class PuertoAndesMaster {


	
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	
	private  String connectionDataPath;

	
	private String user;

	
	private String password;

	
	private String url;

	
	private String driver;
	
	
	private Connection conn;


	
	public PuertoAndesMaster(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	
	private void initConnectionData() {
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * M茅todo que  retorna la conexi贸n a la base de datos
	 * @return Connection - la conexi贸n a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexi贸n a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return DriverManager.getConnection(url, user, password);
	}



	
	public ListaBuques darBuques() throws Exception {
		ArrayList<Buque> buques;
		DAOTablaBuques daoBuques = new DAOTablaBuques();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoBuques.setConn(conn);
			buques = daoBuques.darBuques();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoBuques.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaBuques(buques);
	}

	
	public void updateBuqueSalida(Salida salida) throws Exception {
		DAOTablaSalidas daoSalida = new DAOTablaSalidas();
		try 
		{
			//////Transacci髇
			this.conn = darConexion();
			daoSalida.setConn(conn);
			daoSalida.updateBuqueSalida(salida);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoSalida.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaSalidas darSalidas() throws Exception {
		ArrayList<Salida> salidas;
		DAOTablaSalidas daoSalidas = new DAOTablaSalidas();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoSalidas.setConn(conn);
			salidas = daoSalidas.darSalidas();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoSalidas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaSalidas(salidas);
	}
	
	public ListaLLegadas darLLegadas() throws Exception {
		ArrayList<LLegada> llegadas;
		DAOTablaLLegadas daoLLegadas = new DAOTablaLLegadas();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoLLegadas.setConn(conn);
			llegadas = daoLLegadas.darLLegadass();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoLLegadas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaLLegadas(llegadas);
	}

	
	public ListaExportadores darExportador() throws Exception {
		ArrayList<Exportador> export;
		DAOTablaExportadores daoexpo = new DAOTablaExportadores();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoexpo.setConn(conn);
			export = daoexpo.darExportador();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoexpo.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaExportadores(export);
	
	}
	
	
	public void updateCargaMaritima(Carga_maritima carga) throws Exception {
		DAOTablaCargaMaritima daoSalida = new DAOTablaCargaMaritima();
		try 
		{
			//////Transacci髇
			
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoSalida.setConn(conn);
			daoSalida.updateCargaMaritima(carga);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoSalida.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCarga(Carga carga) throws Exception {
		DAOTablaCargaMaritima daoSalida = new DAOTablaCargaMaritima();
		try 
		{
			//////Transacci髇
			
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoSalida.setConn(conn);
			daoSalida.updateCarga(carga);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoSalida.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}


	
	
}
