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

import tec.mediTEC.medicResources.examen;

@Path("/Examenes")
public class examn {
	private static List<examen> examenes = new ArrayList<>();
	
	public examn(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExamen(){
		if(examenes.isEmpty()){
			return  Response.noContent().build();
		}else{
			return Response.ok().entity(examenes).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newExamen(examen nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			examenes.add(nuevo);
			return Response.ok().build();
		}
	}

}
