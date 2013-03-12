package es.discoteca.app.json.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "cancion")
public class CancionJson {

	@JsonProperty(value = "nombre")
	private String nombre;
	@JsonProperty(value = "duracion")
	private String duracion;
	@JsonProperty(value = "posicion")
	private String posicion;
	@JsonProperty(value = "ident")
	private String ident;

	public String getDuracion() {
		return duracion;
	}

	public String getIdent() {
		return ident;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setDuracion(final String duracion) {
		this.duracion = duracion;
	}

	public void setIdent(final String ident) {
		this.ident = ident;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public void setPosicion(final String posicion) {
		this.posicion = posicion;
	}

}
