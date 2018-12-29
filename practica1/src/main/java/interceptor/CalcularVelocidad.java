package interceptor;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "calcularVelocidad", eager = true)
public class CalcularVelocidad implements Filtro {
	
	public static final int INTERVALO = 60; //Un minuto
	
	public double ejecutar(double o) {
		double distancia=o;
		double velocidad=distancia/(double)(INTERVALO/3600);
		return velocidad;
	}
	
}
