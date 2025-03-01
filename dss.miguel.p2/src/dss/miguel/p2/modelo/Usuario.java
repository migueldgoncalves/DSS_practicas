package dss.miguel.p2.modelo;

import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Dataobject de la aplicacion
@XmlRootElement
@Entity
public class Usuario {
	
	@Id //Id de la entrada en la base de datos
	@GeneratedValue (strategy=GenerationType.IDENTITY) //El valor se genera automaticamente
	private int id;
	private String name;
	private String email;
	
	public Usuario () {
		
	}
	
	public Usuario(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "El usuario con id " + id + " se llama " + name + " y su correo electronico es " + email;
	}
}