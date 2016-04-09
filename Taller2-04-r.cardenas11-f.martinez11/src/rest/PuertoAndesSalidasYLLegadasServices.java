package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.PuertoAndesMaster;
import vos.LLegada;
import vos.ListaBuques;
import vos.ListaLLegadas;
import vos.ListaSalidas;
import vos.Salida;

@Path("salidasYllegadas")
public class PuertoAndesSalidasYLLegadasServices 
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
	@Path("/salidas")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getSalida() {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaSalidas salidas;
		System.out.println("span");
		try {
			System.out.println("span");
			salidas = (ListaSalidas) tm.darSalidas();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(salidas).build();
	}
	
	@GET
	@Path("/llegadas")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getLLegada() {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		ListaLLegadas llegadas;
		System.out.println("span");
		try {
			System.out.println("span");
			llegadas = (ListaLLegadas) tm.darLLegadas();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(llegadas).build();
	}

	@PUT
	@Path("/salida")
	public Response updateBuqueSalida(Salida salida) {
		PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
		try {
			tm.updateBuqueSalida(salida);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(salida).build();
	}
	
	
	
	
	

}
