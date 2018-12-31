package dss.miguel.p2.comunicacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dss.miguel.p2.modelo.Usuario;
import dss.miguel.p2.modelo.BDUsuario;

@Path("/usuarios")
public class ListaCorreosServlet {
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Usuario> getAllUsuariosBrowser() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(BDUsuario.INSTANCE.getAllUsuarios());
		return usuarios;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Usuario> getAllUsuariosApp() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(BDUsuario.INSTANCE.getAllUsuarios());
		return usuarios;
	}
	
	@GET
	@Path("cont")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int cont = BDUsuario.INSTANCE.getAllUsuarios().size();
		return String.valueOf(cont);
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{usuario}")
	public Usuario getUsuarioById(@PathParam("usuario") String id) {
		return BDUsuario.INSTANCE.getUsuarioById(id);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createUsuario(@FormParam("name") String name,
			@FormParam("email") String email,
			@Context HttpServletResponse servletResponse) throws IOException {
		BDUsuario.INSTANCE.createUsuario(name, email);
		servletResponse.sendRedirect("http://localhost:9090/dss.miguel.p2/");
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateUsuario(@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("email") String email,
			@Context HttpServletResponse servletResponse) throws IOException {
		BDUsuario.INSTANCE.updateUsuario(id, name, email);
	}
	
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deleteUsuario(@FormParam("id") String id,
			@Context HttpServletResponse servletResponse) throws IOException {
		BDUsuario.INSTANCE.deleteUsuario(id);
	}
}