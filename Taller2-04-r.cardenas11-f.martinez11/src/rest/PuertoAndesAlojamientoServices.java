package rest;


import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import vos.ListaAlojamiento;
import vos.ListaBodegasLibres;
import vos.ListaBuques;
import vos.ListaReq10;
import vos.ListaSalidas;
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
	
	@GET
	@Path("/libres")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBodegasLibres() {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaBodegasLibres libres;
		System.out.println("span");
		try {
			System.out.println("span");
			libres = (ListaBodegasLibres) tm.darBodegasLibres();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(libres).build();
	}
	@POST
	@Path("/CargarAlojamiento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCargaAlojamiento(Carga_maritima cargaMaritima) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.updateCargaMaritimaYalojamiento(cargaMaritima);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cargaMaritima).build();
	}
	
	
	@GET
	@Path("/Alojaminetos")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAlojamientos() {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaAlojamiento aloja;
		System.out.println("span");
		try {
			System.out.println("span");
			aloja =  tm.darAlojamiento();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aloja).build();
	}

	//FIXME
	@GET
	@Path("/Alojamineto/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAlojamientosFiltrados(@PathParam("id") int id) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaReq10 aloja;
		
		try {
			
			aloja =  tm.darAlojamientoFiltrado(id);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(aloja).build();
	}
}
