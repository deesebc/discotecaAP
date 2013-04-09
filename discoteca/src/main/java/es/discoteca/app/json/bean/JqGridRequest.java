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
	public String filters; // filtro
	@JsonProperty(value = "page")
	public Integer page; // pagina
	@JsonProperty(value = "rows")
	public Integer rows; // cantidad por pagina
	@JsonProperty(value = "sidx")
	public String sidx; // campo ordenacion
	@JsonProperty(value = "sord")
	public String sord; // sentido ordenacion

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
