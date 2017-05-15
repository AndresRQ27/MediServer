package tec.mediTEC;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tec.mediTEC.medicResources.cita;

@Path("/Citas")
public class cit {
	private static List<cita> citas = new ArrayList<>();
	
	public cit(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCitas(){
		if(citas.isEmpty()){
			return  Response.noContent().build();
		}else{
			return Response.ok().entity(citas).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newCita(cita nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			citas.add(nuevo);
			return Response.ok().build();
		}
	}


}
