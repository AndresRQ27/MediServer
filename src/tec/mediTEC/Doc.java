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

import tec.mediTEC.usuarios.Doctor;

@Path("/Doctor")
public class Doc {
	
	private static List<Doctor> doctores = new ArrayList<>();
	
	public Doc(){		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctores(){
		if(doctores.isEmpty()){
			return  Response.noContent().build();
		}else{
			return Response.ok().entity(doctores).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newDoctor(Doctor nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			doctores.add(nuevo);
			return Response.ok().build();
		}
	}

}
