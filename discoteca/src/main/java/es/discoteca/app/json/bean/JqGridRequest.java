/**
 * 
 */
package es.discoteca.app.json.bean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author xe29197
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JqGridRequest {

	// nd 1362652109156

	@JsonProperty(value = "_search")
	public Boolean search;
	@JsonProperty(value = "filters")
	public String filters;
	@JsonProperty(value = "page")
	public Integer page;
	@JsonProperty(value = "rows")
	public Integer rows;
	@JsonProperty(value = "sidx")
	public String sidx;
	@JsonProperty(value = "sord")
	public String sord;

	//
	// @RequestParam("_search") final Boolean search,
	// @RequestParam(value = "filters", required = false) final String filters,
	// @RequestParam(value = "page", required = false) final Integer page,
	// @RequestParam(value = "rows", required = false) final Integer rows,
	// @RequestParam(value = "sidx", required = false) final String sidx,
	// @RequestParam(value = "sord", required = false) final String sord

	public String getFilters() {
		return filters;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getRows() {
		return rows;
	}

	public Boolean getSearch() {
		return search;
	}

	public String getSidx() {
		return sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setFilters(final String filters) {
		this.filters = filters;
	}

	public void setPage(final Integer page) {
		this.page = page;
	}

	public void setRows(final Integer rows) {
		this.rows = rows;
	}

	public void setSearch(final Boolean search) {
		this.search = search;
	}

	public void setSidx(final String sidx) {
		this.sidx = sidx;
	}

	public void setSord(final String sord) {
		this.sord = sord;
	}
}
