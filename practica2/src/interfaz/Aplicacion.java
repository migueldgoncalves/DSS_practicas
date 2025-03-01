package interfaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Familia;

public class Aplicacion {
	
	private static final String PERSISTENCE_UNIT_NAME = "tutorialJPA";
	private static EntityManagerFactory factoria;
	
	public static void main(String[] args) {
		factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factoria.createEntityManager();
		Query q = em.createQuery("SELECT f FROM Familia f");
		System.out.println("Tamano: " + q.getResultList().size());
		
		em.getTransaction().begin();
		Familia f = new Familia();
		f.setDescripcion("descripcion");
		em.persist(f);
		em.getTransaction().commit();
		
		q = em.createQuery("SELECT f FROM Familia f");
		System.out.println("Tamano: " + q.getResultList().size());
		
		em.close(); //Debe ser la ultima linea a utilizar el Entity Manager
	}
}