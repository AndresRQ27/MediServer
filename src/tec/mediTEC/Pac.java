package tec.mediTEC;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tec.mediTEC.usuarios.Paciente;

@Path("/Pacientes")
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
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaciente(@PathParam("id") int id){
		Paciente pcite = this.findPaciente(id);
		if(pcite != null){
			return Response.ok().entity(pcite).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newPaciente(Paciente nuevo){
		if(nuevo == null){
			return Response.noContent().build();
		}else{
			nuevo.enviarCorreo(nuevo.getCorreo());
			pacientes.add(nuevo);
			return Response.status(201).build();
		}
	}

	@PUT
	@Path("/correo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCorreo(@PathParam("id") int id, String nuevo){
		Paciente pcite = this.findPaciente(id);
		if(pcite != null && nuevo != null){
			pcite.setCorreo(nuevo);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@PUT
	@Path("/verificaion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response habilitar(int id){
		Paciente pcite = this.findPaciente(id);
		if (pcite != null){
			pcite.setHabilitado(true);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@DELETE
	@Path("{id}")
	public Response remove(@PathParam ("id") int id){
		Paciente pcite = this.findPaciente(id);
		if (pcite != null){
			pacientes.remove(pcite);
			return Response.status(410).build();
		}else{
			return Response.noContent().build();
		}
	}
	
	private Paciente findPaciente(int id){
		for(Paciente i : pacientes){
			if(i.getCodigo() == id){
				return i;
			}else{
				return null;
			}
		}
		return null;
	}
}
