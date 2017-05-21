package tec.mediTEC;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.http.HTTPException;

import tec.mediTEC.medicResources.casoClinico;
import tec.mediTEC.medicResources.examen;
import tec.mediTEC.medicResources.medic;

@Path("/CasosClinicos")
public class casCli {
	
	private static List<casoClinico> casosClinicos = new ArrayList<>();
	
	public casCli(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCasos(){
		if(casosClinicos.isEmpty()){
			return  Response.noContent().build();
		}else{
			return Response.ok().entity(casosClinicos).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public casoClinico getCaso(@PathParam("id") String id){
		casoClinico caso = this.findCaso(id);
		if(caso != null){
			return caso;
		}else{
			throw new HTTPException(404);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newCasoCli(casoClinico nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			casosClinicos.add(nuevo);
			return Response.ok().build();
		}
	}
	
	@POST
	@Path("/examenes/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void newExamen(@PathParam("id") String id, examen nuevo){
		casoClinico caso = this.findCaso(id);
		if(caso != null){
			caso.getExamenes().add(nuevo);
		}
		
	}
	
	@POST
	@Path("/medicamentos/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void newMedicamento(@PathParam("id") String id, medic nuevo){
		casoClinico caso = this.findCaso(id);
		if(caso != null){
			caso.getMedicamentos().add(nuevo);
		}
		
	}
	
	@PUT
	@Path("/nombre/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateNombre(@PathParam("id") String id, String nombre){
		casoClinico caso = findCaso(id);
		if(caso != null){
			caso.setNombre(nombre);
		}
		
	}
	
	
	private casoClinico findCaso(String id){
		for(casoClinico i : casosClinicos){
			if(i.getNombre().equals(id)){
				return i;
			}else{
				return null;
			}
		}
		return null;
	}

}
