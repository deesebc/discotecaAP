/**
 * 
 */
package es.discoteca.app.json.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author xe29197
 * 
 */
public class DataTablesResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "iTotalRecords")
	public int totalRecords;

	@JsonProperty(value = "iTotalDisplayRecords")
	public int totalDisplayRecords;

	@JsonProperty(value = "sEcho")
	public String echo;

	@JsonProperty(value = "sColumns")
	public String columns;

	@JsonProperty(value = "aaData")
	public List<T> data = new ArrayList<T>();

	public DataTablesResponse() {
	}
}
