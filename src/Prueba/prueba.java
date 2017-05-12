package Prueba;

import javax.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

@Path("/prueba")
public class prueba {
	
	private static List<paciente> pruebas = new ArrayList<>();
	
	public  prueba() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getprueba(){
		if(pruebas.isEmpty()){
			return  Response.noContent().build();
		}else{
			return Response.ok().entity(pruebas).build();
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newPaciente(paciente nuevo){
		if(nuevo == null){
			return Response.noContent().build();
		}else{
			pruebas.add(nuevo);
			return Response.ok().build();
		}
	}
	

}
