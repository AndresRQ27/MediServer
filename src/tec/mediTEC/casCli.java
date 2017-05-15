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

import tec.mediTEC.medicResources.casoClinico;

@Path("/CasoClinico")
public class casCli {
	
	private static List<casoClinico> casosClinicos = new ArrayList<>();
	
	public casCli(){
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCasoCli(){
		if(casosClinicos.isEmpty()){
			return  Response.noContent().build();
		}else{
			return Response.ok().entity(casosClinicos).build();
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

}
