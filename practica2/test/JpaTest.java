package pruebas;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.eclipselink.modelo.Familia;
import jpa.eclipselink.modelo.Persona;

public class JpaTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "relaciones_persistentes";
	private EntityManagerFactory factoria;
	
	@Before
	public void setUp() throws Exception {
		factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factoria.createEntityManager();
		// Comenzar una nueva transaccion local de tal forma que pueda persistir
		//como una nueva entidad.
		// Leer las entradas que ya hay en la base de datos.
		// Las personas no deben tener ningun atributo asignado todavia
		Query q = em.createQuery("select m from Persona m");
		// Comprobar si necesitamos crear entradas en la base
		boolean crearseNuevasEntradas = (q.getResultList().size() == 0);
		if (crearseNuevasEntradas){
			// Vamos a ello...
			assertTrue(q.getResultList().size() == 0);
			Familia familia = new Familia();
			familia.setDescripcion("Familia Martinez");
			em.persist(familia);
			for (int i = 0; i < 20; i++) {
				//Crearse una "persona" y asignar sus atributos con: setNombre(...) y setApellidos(...)
				em.persist(persona);
				//anadir "persona" al ListArray<Persona> que representa a "familia"
				// ahora hacemos que persista la relacion familia-persona
				em.persist(persona);
				em.persist(familia);
			}
		}
		// Ahora hay que hacer "commit" de la transaccion, lo que causa que la
		//entidad se salve en la base de datos.
		em.getTransaction().commit();
		//Ahora hay que cerrar el EntityManager o perderemos nuestras entradas.
		em.close();
	}//setUp()
	
	@Test
	public void comprobarPersonas() {
	//ahora vamos a comprobar la base de datos para ver si las entradas que hemos creado estan alli
	//Para eso, nos crearemos un gestor de entidades "fresco"
	//Realizaremos una consulta simple que consistira en seleccionar a todas las personas
	//Si todo ha ido bien, en la lista de personas hemos de tener a 20 miembros:
	//utilizar "assertTrue()", "getResultList()" y "size()" para comprobarlo.
	//Acordarse de cerrar el gestor de entidades
	}
	
	@Test
	public void comprobarFamilia() {
	//Para esto, nos crearemos un gestor de entidades "fresco"
	//Recorrer cada una de las entidades y mostrar cada uno de sus campos asi como la fecha de creacion
	//Deberiamos tener una familia con 20 personas
	//Utilizar "assertTrue()", "getResultList()", "size()" y "getSingleResult()" para determinarlo
	//Acordarse de cerrar el gestor de entidades
	}
	
	@Test(expected = javax.persistence.NoResultException.class)
	public void eliminarPersona() {
	//Para esto, nos crearemos un gestor de entidades "fresco"
	// Begin a new local transaction so that we can persist a new entity
	//Comenzar una nueva transaccion local de tal manera que podamos hacer persitente una nueva
	//entidad. Ahora me creare la consulta necesaria eliminar la persona de nombre y apellidos
	//que indicare despues.
	
	Query q = em.createQuery("SELECT p FROM Persona p WHERE p.nombre=:nombre AND p.apellido=:apellido");
	
	//Ahora asigno los parametros
	q.setParameter("nombre", "Pepe_1");
	q.setParameter("apellido", "Martinez_!");
	
	//Ahora utilizo el metodo: "getSingleResult()" para obtener a la persona que me interesa y
	//los metodos: "remove(persona)" y "commit()" para eliminarla de la entidad y confirmar la
	//eliminacion, respectivamente.
	//Acordarse de cerrar el gestor de entidades
	}