/**
 * 
 */
package es.discoteca.app.json.bean;

import java.util.List;

/**
 * @author xe29197
 * 
 */
public class JqGridResponse<T> {
	/**
	 * Current page of the query
	 */
	private String page;

	/**
	 * Total pages for the query
	 */
	private String total;

	/**
	 * Total number of records for the query
	 */
	private String records;

	/**
	 * An array that contains the actual objects
	 */
	private List<T> rows;

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
