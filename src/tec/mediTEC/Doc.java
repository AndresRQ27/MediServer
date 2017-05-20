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

import tec.mediTEC.medicResources.cita;
import tec.mediTEC.usuarios.Doctor;

@Path("/Doctores")
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
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor getDoctor(@PathParam("id") int id){
		Doctor doc = this.findDoc(id);
		if (doc!= null){
			return doc;
		}else{
			throw new HTTPException(404);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newDoctor(Doctor nuevo){
		if (nuevo == null){
			return Response.noContent().build();
		}else{
			nuevo.enviarCorreo(nuevo.getCorreo());
			doctores.add(nuevo);
			return Response.ok().build();
		}
	}
	
	@POST
	@Path("/citas/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void newCita(@PathParam("id") int id, cita nueva){
		Doctor doc = this.findDoc(id);
		if (doc != null){
			doc.getCitas().add(nueva);
		}		
	}

	@PUT
	@Path("/correo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCorreo(@PathParam("id") int id, String nuevo){
		Doctor doc = this.findDoc(id);
		if (doc != null && nuevo != null){
			doc.setCorreo(nuevo);
		}
		
	}
	
	@PUT
	@Path("/calificacion/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCalificacion(@PathParam("id") int id, int nueva){
		Doctor doc = this.findDoc(id);
		if(doc != null){
			doc.setCalificación(doc.getCalificación() + nueva);
		}
		
	}
	
	private Doctor findDoc(int id){
		for(Doctor i : doctores){
			if(i.getCodigo() == id){
				return i;
			}else{
				return null;
			}
		}
		return null;
	}

}
