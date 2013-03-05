/**
 * 
 */
package es.discoteca.app.json.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author xe29197
 * 
 */
@XmlRootElement(name = "disco")
public class DiscoJson implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "nombre")
	private String nombre;
	@JsonProperty(value = "grupo")
	private String grupo;

	public String getGrupo() {
		return grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setGrupo(final String grupo) {
		this.grupo = grupo;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}
