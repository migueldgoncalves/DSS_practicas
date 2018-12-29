package interceptor;

public class Main {
	
	public static void main(String[] args) {
		
		GestorFiltros gestorFiltros = new GestorFiltros();
		gestorFiltros.setObjetivo(new Interfaz());
		gestorFiltros.addFiltro(new CalcularVelocidad());
		gestorFiltros.addFiltro(new CalcularDistancia());
		
		Cliente cliente = new Cliente();
		cliente.setGestorFiltros(gestorFiltros);
		cliente.enviarPeticion(500); //numero inicial de vueltas del eje
	}
}
