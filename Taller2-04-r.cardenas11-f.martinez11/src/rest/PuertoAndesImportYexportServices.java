package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.PuertoAndesMaster;
import vos.Exportador;
import vos.ListaExportadores;
import vos.ListaReq9;
import vos.ListaSalidas;
import vos.Req9;

@Path("importYexport")
public class PuertoAndesImportYexportServices 
{
	@Context
	private ServletContext context;

	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	@GET
	@Path("/exportador")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getExportador() 
	{
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaExportadores expo;
		System.out.println("span");
		try {
			System.out.println("span");
			expo = (ListaExportadores) tm.darExportador();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(expo).build();
	}
	
	//FIXME
	

	@GET
	@Path("/export/{valor}/{tipo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getExportadorCargasFiltradas( @PathParam("valor") int valor , @PathParam("tipo") String tipo) 
	{
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaReq9 expo;
		System.out.println("span");
		try {
			System.out.println("span");
			expo = (ListaReq9) tm.darCargarMaritimaFiltradas(valor, tipo);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(expo).build();
	}
	
	
}
