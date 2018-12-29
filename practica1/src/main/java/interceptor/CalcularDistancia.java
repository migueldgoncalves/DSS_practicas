package interceptor;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "calcularDistancia", eager = true)
public class CalcularDistancia implements Filtro {
	
	public double ejecutar(double o) {
		return 0;
	}
	
}