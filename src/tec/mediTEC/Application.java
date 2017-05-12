package tec.mediTEC;

import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
	public Application() {
		register(Prueba.prueba.class);
		register(Doc.class);
		register(Pac.class);
		register(casCli.class);
		register(cit.class);
		register(examn.class);
		register(medi.class);

	}

}
