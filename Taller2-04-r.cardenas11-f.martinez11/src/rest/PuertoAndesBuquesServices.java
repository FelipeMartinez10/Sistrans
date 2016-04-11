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
import vos.Buque;
import vos.Carga;
import vos.Carga_maritima;
import vos.ListaBuques;
import vos.Salida;


@Path("buques")
public class PuertoAndesBuquesServices {



	
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
	@Path("/eventoCarga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCargaMaritima(Carga_maritima cargaMaritima) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.updateCargaMaritima(cargaMaritima);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cargaMaritima).build();
	}
	
	@POST
	@Path("/Carga")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCarga(Carga cargaMaritima) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.updateCarga(cargaMaritima);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cargaMaritima).build();
	}
	
<<<<<<< HEAD
	@POST
	@Path("/CargarAlojamiento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCargaAlojamiento(Carga_maritima cargaMaritima) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.updateCargaMaritimaYalojamiento(cargaMaritima);
=======
	@DELETE
	@Path("/descargar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response descargarCargaMaritima(Carga_maritima cargaMaritima) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.descargarBuque(cargaMaritima);;
>>>>>>> 22287ea4ae686948b5cd16f396aa1f4b7650a740
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cargaMaritima).build();
	}
<<<<<<< HEAD
	
=======
>>>>>>> 22287ea4ae686948b5cd16f396aa1f4b7650a740
	
	@POST
	@Path("/descargarBuque")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response descargarBuque(Carga_maritima cargaMaritima) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.descargarBuqueRq11(cargaMaritima);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cargaMaritima).build();
	}
	
}
