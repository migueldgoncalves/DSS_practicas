package interceptor;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Interfaz {
	
	public double ejecutar(double peticion) throws IOException, URISyntaxException {
		String url = "http://localhost:9090/practica1/home.jsf";
		
		if(Desktop.isDesktopSupported()) {
			// Windows
			Desktop.getDesktop().browse(new URI(url));
		} else {
			// Ubuntu
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("/usr/bin/firefox -new-window " + url);
		}
		return 0.0d;
	}
	
}