package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import dao.DAOTablaAlojamientoBodega;
import dao.DAOTablaBodega;
import dao.DAOTablaBuques;
import dao.DAOTablaCargaMaritima;
import dao.DAOTablaExportadores;
import dao.DAOTablaLLegadas;
import dao.DAOTablaSalidas;
import vos.Alojamiento_bodega;
import vos.Alojamineto_bodegaEvento;
import vos.Bodega;
import vos.Buque;
import vos.Carga;
import vos.Carga_maritima;
import vos.Carga_maritimaEvento;
import vos.Exportador;
import vos.ListaBuques;
import vos.ListaCargar_maritima;
import vos.ListaCargas_maritimaID;
import vos.ListaExportadores;
import vos.ListaLLegadas;
import vos.ListaReq10;
import vos.ListaReq7;
import vos.ListaReq9;
import vos.ListaSalidas;
import vos.Req10;
import vos.Req7;
import vos.Req9;
import vos.Salida;
import vos.LLegada;
import vos.ListaAlojamiento;
import vos.ListaBodegasLibres;


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
	
	public void descargarBuque(Carga_maritima carga) throws Exception {
		DAOTablaCargaMaritima daoSalida = new DAOTablaCargaMaritima();
		try 
		{
			//////Transacci髇
			
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoSalida.setConn(conn);
			daoSalida.descargarCargaDeBarco(carga);;
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
	
	public void registrarAlojamiento(Alojamiento_bodega pAloja) throws Exception {
		DAOTablaAlojamientoBodega daoSalida = new DAOTablaAlojamientoBodega();
		try 
		{
			//////Transacci髇
			
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoSalida.setConn(conn);
			daoSalida.registrarAlojamiento(pAloja);
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

	public ListaBodegasLibres darBodegasLibres() throws Exception {
		ArrayList<Bodega> bodegas;
		DAOTablaBodega daoBodegas = new DAOTablaBodega();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			daoBodegas.setConn(conn);
			bodegas = daoBodegas.getBodegasLibres();

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
				daoBodegas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaBodegasLibres(bodegas);
	}
	public void descargarBuqueRq11(Carga_maritima carga) throws Exception {
		
		List<Bodega> bodegasLibres = darBodegasLibres().getBodegas();
		Iterator<Bodega> it = bodegasLibres.iterator();
		boolean seguir = true;
		Bodega res = null;
		while(it.hasNext() && seguir)
		{
			Bodega actual = (Bodega) it.next();
			if( actual != null)
			{
				seguir = false;
				res = actual;
			}
		}
		if(res != null)
		{
			try
			{
				List<Carga_maritima> lista = darCargarMaritimaID(carga.getID_CARGA(),carga.getID_BUQUE()).getCargas();
				
				if(lista.size()>0)
				{
					descargarBuque(carga);
					Alojamiento_bodega nuevo = new Alojamiento_bodega(res.getID_BODEGA(),1,carga.getID_CARGA());
					registrarAlojamiento(nuevo);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e.getStackTrace());
			}
			
		}
		
		
	}
	public void updateCargaMaritimaYalojamiento(Carga_maritima carga) throws Exception {
		DAOTablaCargaMaritima daoSalida = new DAOTablaCargaMaritima();
		DAOTablaAlojamientoBodega dao2 = new DAOTablaAlojamientoBodega();
		try 
		{
			//////Transacci髇
			
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoSalida.setConn(conn);
			daoSalida.updateCargaMaritima(carga);
			dao2.setConn(conn);
			dao2.eliminarCargaAlojada(carga.getID_CARGA());
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
	
	
	
	public ListaCargar_maritima darCargarMaritima() throws Exception {
		ArrayList<Carga_maritimaEvento> cargaMarit;
		DAOTablaCargaMaritima cargarMar = new DAOTablaCargaMaritima();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			cargarMar.setConn(conn);
			System.out.println("ento acaaaa");
			cargaMarit =  cargarMar.darCargasMaritimas();

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
				cargarMar.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCargar_maritima(cargaMarit);
	}
	
	public ListaAlojamiento darAlojamiento() throws Exception {
		ArrayList<Alojamineto_bodegaEvento> cargaMarit;
		DAOTablaAlojamientoBodega aloja = new DAOTablaAlojamientoBodega();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			aloja.setConn(conn);
			System.out.println("ento acaaaa");
			cargaMarit =  aloja.darAlojamiento();

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
				aloja.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaAlojamiento(cargaMarit);
	}


	public ListaCargas_maritimaID darCargarMaritimaID(int id_carga, int id_buque)throws Exception  {
		ArrayList<Carga_maritima> cargaMarit;
		DAOTablaCargaMaritima cargarMar = new DAOTablaCargaMaritima();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			cargarMar.setConn(conn);
			System.out.println("ento acaaaa");
			cargaMarit =  cargarMar.darCargasMaritimasID(id_carga,id_buque);

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
				cargarMar.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCargas_maritimaID(cargaMarit);
	}
	//FIXME
	//----------------req7y8----------------------------------------
	public ListaReq7 darSalidasFiltradas1(String fecha1,String fecha2,String nombre, String tipo) throws Exception {
		ArrayList<Req7> cargaMarit;
		DAOTablaSalidas aloja = new DAOTablaSalidas();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			aloja.setConn(conn);
			
			cargaMarit =  aloja.darSalidasFiltradas(fecha1, fecha2, nombre, tipo);

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
				aloja.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReq7(cargaMarit);
	}
	public ListaReq7 darSalidasFiltradas2(String fecha1,String fecha2,String nombre, String tipo) throws Exception {
		ArrayList<Req7> cargaMarit;
		DAOTablaSalidas aloja = new DAOTablaSalidas();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			aloja.setConn(conn);
			
			cargaMarit =  aloja.darSalidasFiltradas2(fecha1, fecha2, nombre, tipo);

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
				aloja.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReq7(cargaMarit);
	}
	
	public ListaReq7 darLLegadasFiltradas1(String fecha1,String fecha2,String nombre, String tipo) throws Exception {
		ArrayList<Req7> cargaMarit;
		DAOTablaLLegadas aloja = new DAOTablaLLegadas();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			aloja.setConn(conn);
			
			cargaMarit =  aloja.darLLegadasFiltradas(fecha1, fecha2, nombre, tipo);

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
				aloja.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReq7(cargaMarit);
	}
	
	public ListaReq7 darLLegadasFiltradas2(String fecha1,String fecha2,String nombre, String tipo) throws Exception {
		ArrayList<Req7> cargaMarit;
		DAOTablaLLegadas aloja = new DAOTablaLLegadas();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			aloja.setConn(conn);
			
			cargaMarit =  aloja.darLLegadasFiltradas(fecha1, fecha2, nombre, tipo);

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
				aloja.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReq7(cargaMarit);
	}
	
	//----------------req9----------------------------------------
	
	public ListaReq9 darCargarMaritimaFiltradas(int valor, String tipo)throws Exception  {
		ArrayList<Req9> cargaMarit;
		DAOTablaCargaMaritima cargarMar = new DAOTablaCargaMaritima();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			cargarMar.setConn(conn);
		
			cargaMarit =  cargarMar.darCargasMaritimasFiltradas(valor, tipo);

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
				cargarMar.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReq9(cargaMarit);
	}
	
	//----------------req10---------------------------------------
	
	public ListaReq10 darAlojamientoFiltrado(int id) throws Exception {
		ArrayList<Req10> cargaMarit;
		DAOTablaAlojamientoBodega aloja = new DAOTablaAlojamientoBodega();
		try 
		{
			//////Transacci贸n
			this.conn = darConexion();
			aloja.setConn(conn);
			System.out.println("ento acaaaa");
			cargaMarit =  aloja.darAlojamientoFiltrado(id);

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
				aloja.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReq10(cargaMarit);
	}
	
	
}
	
	

