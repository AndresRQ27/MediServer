package tec.mediTEC;

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

import tec.mediTEC.medicResources.casoClinico;
import tec.mediTEC.medicResources.examen;
import tec.mediTEC.medicResources.medic;
import tec.mediTEC.trees.BinaryTree;

@Path("/CasosClinicos")
public class casCli {
	
	private static BinaryTree<casoClinico> casosClinicos = new BinaryTree<casoClinico>();
	
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
	public Response getCaso(@PathParam("id") String id){
		casoClinico caso = casosClinicos.search(new casoClinico(id));
		if(caso != null){
			return Response.ok().entity(caso).build();
		}else{
			return Response.noContent().build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newCasoCli(casoClinico nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			casosClinicos.insert(nuevo);
			return Response.status(201).build();
		}
	}
	
	@POST
	@Path("/examenes/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newExamen(@PathParam("id") String id, examen nuevo){
		casoClinico caso = casosClinicos.search(new casoClinico(id));
		if(caso != null){
			caso.getExamenes().add(nuevo);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@POST
	@Path("/medicamentos/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newMedicamento(@PathParam("id") String id, medic nuevo){
		casoClinico caso = casosClinicos.search(new casoClinico(id));
		if(caso != null){
			caso.getMedicamentos().add(nuevo);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@PUT
	@Path("/nombre/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateNombre(@PathParam("id") String id, String nombre){
		casoClinico caso = casosClinicos.search(new casoClinico(id));
		if(caso != null){
			caso.setNombre(nombre);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") String id){
		casoClinico caso = casosClinicos.search(new casoClinico(id));
		if(caso != null){
			casosClinicos.remove(caso);
			return Response.status(410).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	

}
