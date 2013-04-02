package es.discoteca.app.json.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "interprete")
public class InterpreteJson {

	@JsonProperty(value = "nombre")
	private String nombre;
	@JsonProperty(value = "instrumento")
	private String instrumento;
	@JsonProperty(value = "ident")
	private String ident;

	public String getIdent() {
		return ident;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setIdent(final String ident) {
		this.ident = ident;
	}

	public void setInstrumento(final String instrumento) {
		this.instrumento = instrumento;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}
