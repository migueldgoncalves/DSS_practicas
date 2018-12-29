package interceptor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "cliente", eager = true)
public class Cliente {
	
	@ManagedProperty(value = "#{gestorFiltros}")
	GestorFiltros gestor = null;
	
	public Cliente() {
		
	}
	
	public void setGestorFiltros(GestorFiltros gestor) {
		this.gestor=gestor;
	}
	
	public void enviarPeticion(double peticion) {
		gestor.ejecutar(peticion);
	}
}
