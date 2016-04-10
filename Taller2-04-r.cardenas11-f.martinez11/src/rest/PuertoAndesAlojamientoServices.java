package rest;


import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import tm.PuertoAndesMaster;
import vos.Alojamiento_bodega;
import vos.Bodega;
import vos.Buque;
import vos.Carga;
import vos.Carga_maritima;
import vos.ListaBuques;
import vos.Salida;


@Path("alojamiento")
public class PuertoAndesAlojamientoServices {



	
	@Context
	private ServletContext context;

	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	

	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBuques() {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaBuques buques;
		System.out.println("span");
		try {
			System.out.println("span");
			buques = tm.darBuques();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(buques).build();
	}

	
	@POST
	@Path("/alojamientoBodega")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarAlojamiento(Alojamiento_bodega pAloja) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.registrarAlojamiento(pAloja);;
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(pAloja).build();
	}
	
	
	
}
