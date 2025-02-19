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

import tec.mediTEC.medicResources.medic;

@Path("/Medicamento")
public class medi {
private static List<medic> medicamentos = new ArrayList<>();
	
	public medi(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedic(){
		if(medicamentos.isEmpty()){
			return  Response.noContent().build();
		}else{
			return Response.ok().entity(medicamentos).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newMedic(medic nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			medicamentos.add(nuevo);
			return Response.ok().build();
		}
	}
}
