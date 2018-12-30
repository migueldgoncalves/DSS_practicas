package mio.xml.jaxb.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "libro")
// Ahora se va a definir el orden en el cual se escriben los campos en el documento XML
@XmlType(propOrder = { "autor", "nombre", "editorial", "isbn" })
public class Libro {
	private String nombre;
	private String autor;
	private String editorial;
	private String isbn;

	// Si te gusta otro nombre para una variable,se puede cambiar con facilidad
	// antes de sacarlo hacia la corriente de salida XML:
	@XmlElement(name = "titulo")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}