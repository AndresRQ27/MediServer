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

import tec.mediTEC.medicResources.cita;
import tec.mediTEC.trees.SplayTree;
import tec.mediTEC.usuarios.Doctor;

@Path("/Doctores")
public class Doc {
	
	private static SplayTree<Doctor> doctores = new SplayTree<Doctor>();
	
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
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctor(@PathParam("id") int id){
		Doctor doc = doctores.searching(new Doctor(id));
		if (doc!= null){
			return Response.ok().entity(doc).build();
		}else{
			return Response.noContent().build();
		}
	}
	
	@GET
	@Path("/citas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCitas(@PathParam("id") int id){
		Doctor doc = doctores.searching(new Doctor(id));
		if (doc != null){
			return Response.ok().entity(doc.getCitas()).build();
		}else{
			return Response.noContent().build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctor(Doctor nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			nuevo.enviarCorreo(nuevo.getCorreo());
			doctores.insert(nuevo);
			return Response.status(201).entity("{\"id\":"+nuevo.getCodigo()	+"}").build();
		}
	}
	
	@POST
	@Path("/citas/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newCita(@PathParam("id") int id, cita nueva){
		Doctor doc = doctores.searching(new Doctor(id));
		if (doc != null){
			doc.getCitas().insert(nueva);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
	}

	@PUT
	@Path("/correo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCorreo(@PathParam("id") int id, String nuevo){
		Doctor doc = doctores.searching(new Doctor(id));
		if (doc != null && nuevo != null){
			doc.setCorreo(nuevo);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@PUT
	@Path("/calificacion/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCalificacion(@PathParam("id") int id, int nueva){
		Doctor doc = doctores.searching(new Doctor(id));
		if(doc != null){
			doc.setCalificacion(doc.getCalificacion() + nueva);
			return Response.status(201).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	@DELETE
	@Path("{id}")
	public Response remove(@PathParam ("id") int id){
		Doctor doc = doctores.searching(new Doctor(id));
		if (doc != null){
			doctores.remove(doc);
			return Response.status(410).build();
		}else{
			return Response.noContent().build();
		}
	}
	
	@DELETE
	@Path("/citas/{id}/{cit}")
	public Response removeCita(@PathParam("id") int id, @PathParam("cit") int cit){
		Doctor doc = doctores.searching(new Doctor(id));
		if(doc != null){
			doc.getCitas().remove(cit);
			return Response.status(410).build();
		}else{
			return Response.noContent().build();
		}
		
	}
	
	

}
