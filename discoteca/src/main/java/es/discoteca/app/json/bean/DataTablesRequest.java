/**
 * 
 */
package es.discoteca.app.json.bean;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author xe29197
 * 
 */
public class DataTablesRequest implements Serializable {

	private static final long serialVersionUID = -2104355708988235320L;

	@JsonProperty(value = "sEcho")
	public String echo;

	@JsonProperty(value = "iColumns")
	public int numColumns;

	@JsonProperty(value = "sColumns")
	public String columns;

	@JsonProperty(value = "iDisplayStart")
	public int displayStart;

	@JsonProperty(value = "iDisplayLength")
	public int displayLength;

	// has to be revisited for Object type dataProps.
	@JsonProperty(value = "amDataProp")
	public List<Integer> dataProp;

	@JsonProperty(value = "sSearch")
	public String searchQuery;

	@JsonProperty(value = "asSearch")
	public List<String> columnSearches;

	@JsonProperty(value = "bRegex")
	public boolean hasRegex;

	@JsonProperty(value = "abRegex")
	public List<Boolean> regexColumns;

	@JsonProperty(value = "abSearchable")
	public List<Boolean> searchColumns;

	@JsonProperty(value = "iSortingCols")
	public int sortingCols;

	@JsonProperty(value = "aiSortCol")
	public List<Integer> sortedColumns;

	@JsonProperty(value = "asSortDir")
	public List<String> sortDirections;

	@JsonProperty(value = "abSortable")
	public List<Boolean> sortableColumns;

	public DataTablesRequest() {
	}
}
