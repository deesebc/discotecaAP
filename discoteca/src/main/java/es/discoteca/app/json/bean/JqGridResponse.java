/**
 * 
 */
package es.discoteca.app.json.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author xe29197
 * 
 */
public class JqGridResponse<T> {
	/**
	 * Current page of the query
	 */
	@JsonProperty(value = "page")
	private String page;

	/**
	 * Total pages for the query
	 */
	@JsonProperty(value = "total")
	private String total;

	/**
	 * Total number of records for the query
	 */
	@JsonProperty(value = "records")
	private String records;

	/**
	 * An array that contains the actual objects
	 */
	@JsonProperty(value = "rows")
	private List<T> rows;

	@JsonProperty(value = "error")
	private String error;

	public String getError() {
		return error;
	}

	public String getPage() {
		return page;
	}

	public String getRecords() {
		return records;
	}

	public List<T> getRows() {
		return rows;
	}

	public String getTotal() {
		return total;
	}

	public void setError(final String error) {
		this.error = error;
	}

	public void setPage(final String page) {
		this.page = page;
	}

	public void setRecords(final String records) {
		this.records = records;
	}

	public void setRows(final List<T> rows) {
		this.rows = rows;
	}

	public void setTotal(final String total) {
		this.total = total;
	}
}
