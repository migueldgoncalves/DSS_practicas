package interceptor;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "gestorFiltros", eager = true)
public class GestorFiltros {
	
	@ManagedProperty(value = "#{filtro}")
	private ArrayList<Filtro> filtros = new ArrayList<Filtro>();
	@ManagedProperty(value = "#{interfaz}")
	private Interfaz objetivo;
	
	public void addFiltro(Filtro filtro) {
		filtros.add(filtro);
	}
	
	public void setObjetivo(Interfaz objetivo) {
		this.objetivo=objetivo;
	}
	
	public void ejecutar(double peticion) {
		for(Filtro filtro : filtros) {
			System.out.println("Nueva velocidad (m/s) "+filtro.ejecutar(peticion));
		}
		try {
			objetivo.ejecutar(peticion);
		}
		catch (Exception e) {
			System.out.println("An Exception ocurred");
		}
	}
	
}