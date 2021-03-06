package es.discoteca.app.json.bean;

// Generated 01-mar-2013 9:51:56 by Hibernate Tools 4.0.0

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Disco generated by hbm2java
 */
@XmlRootElement(name = "libro")
public class LibroJson {

	@JsonProperty(value = "ident")
	private String ident;
	@JsonProperty(value = "nombre")
	private String nombre;
	@JsonProperty(value = "autor")
	private String autor;
	@JsonProperty(value = "argumento")
	private String argumento;
	@JsonProperty(value = "paginas")
	private String paginas;
	@JsonProperty(value = "volumen")
	private String volumen;
	@JsonProperty(value = "serie")
	private String serie;

	public LibroJson() {
		super();
	}

	public LibroJson(final String ident) {
		this.ident = ident;
	}

	public LibroJson(final String ident, final String nombre, final String autor,
			final String argumento, final String paginas, final String volumen, final String serie) {
		super();
		this.ident = ident;
		this.nombre = nombre;
		this.autor = autor;
		this.argumento = argumento;
		this.paginas = paginas;
		this.volumen = volumen;
		this.serie = serie;
	}

	public String getArgumento() {
		return argumento;
	}

	public String getAutor() {
		return autor;
	}

	public String getIdent() {
		return ident;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPaginas() {
		return paginas;
	}

	public String getSerie() {
		return serie;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setArgumento(final String argumento) {
		this.argumento = argumento;
	}

	public void setAutor(final String autor) {
		this.autor = autor;
	}

	public void setIdent(final String ident) {
		this.ident = ident;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public void setPaginas(final String paginas) {
		this.paginas = paginas;
	}

	public void setSerie(final String serie) {
		this.serie = serie;
	}

	public void setVolumen(final String volumen) {
		this.volumen = volumen;
	}

}
