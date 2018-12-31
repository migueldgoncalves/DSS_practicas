package dss.miguel.p2.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;

public enum BDUsuario {
	
	INSTANCE; //Buena forma de implementar un singleton
	
	private static final String PERSISTENCE_UNIT_NAME = "practica2";
	//private static EntityManagerFactory factoria; //Necesario para ejecutar el main
	private final EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private EntityManager em = factoria.createEntityManager();
	
	private BDUsuario() {
		Usuario u1 = new Usuario("Fernando", "Fernando@email.com");
		Usuario u2 = new Usuario("Hernando", "Hernando@email.com");
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(u1);
		em.persist(u2);
		t.commit();
		em.close();
	}
	
	public List<Usuario> getAllUsuarios(){
		em = factoria.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("SELECT u FROM Usuario u");
		@SuppressWarnings("unchecked")
		List<Usuario> results = q.getResultList();
		for (Usuario u : results)
			System.out.println(u.toString());
		System.out.println("La base de datos tiene " + results.size() + " usuarios");
		em.close();
		return results;
	}
	
	public Usuario getUsuarioById(String id){
		em = factoria.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.id=" +
				Integer.parseInt(id));
		@SuppressWarnings("unchecked")
		List<Usuario> result = q.getResultList();
		em.close();
		return result.get(0);
	}
	
	public void updateUsuario(String id, String name, String email) {
		em = factoria.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Usuario usuario = em.find(Usuario.class, Integer.parseInt(id));
		usuario.setName(name);
		usuario.setEmail(email);
		t.commit();
		em.close();
	}
	
	public void createUsuario(String name, String email) {
		em = factoria.createEntityManager();
		Usuario u = new Usuario(name, email);
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(u);
		t.commit();
		em.close();
	}
	
	public void deleteUsuario(String id) {
		em = factoria.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Usuario usuario = em.find(Usuario.class, Integer.parseInt(id));
		em.remove(usuario);
		t.commit();
		em.close();
	}
/*
	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factoria.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u");
		Usuario u = new Usuario("name", "email");
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(u);
		t.commit();
		@SuppressWarnings("unchecked")
		List<Usuario> results = q.getResultList();
		for (Usuario us : results)
			System.out.println(us.toString());
		System.out.println("La base de datos tiene " + results.size() + " usuarios");
		
		t.begin();
		Usuario usuario = em.find(Usuario.class, 1);
		em.remove(usuario);
		t.commit();
		results = q.getResultList();
		for (Usuario us : results)
			System.out.println(us.toString());
		System.out.println("La base de datos tiene " + results.size() + " usuarios");
		em.close(); //Debe ser la ultima linea a utilizar el Entity Manager
	}*/
}