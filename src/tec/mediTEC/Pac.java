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

import tec.mediTEC.usuarios.Paciente;

@Path("/Paciente")
public class Pac {
	
	private static List<Paciente> pacientes = new ArrayList<>();
	
	public Pac(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPacientes(){
		if(pacientes.isEmpty()){
			return Response.noContent().build();
		}else{
			return Response.ok().entity(pacientes).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newPaciente(Paciente nuevo){
		if(nuevo == null){
			return Response.noContent().build();
		}else{
			pacientes.add(nuevo);
			return Response.ok().build();
		}
	}

}
