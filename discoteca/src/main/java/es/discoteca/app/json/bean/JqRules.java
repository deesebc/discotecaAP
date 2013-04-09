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
public class JqRules {

	@JsonProperty(value = "field")
	private String field;
	@JsonProperty(value = "op")
	private String op;
	@JsonProperty(value = "data")
	private String data;

	public JqRules() {
		super();
	}

	public JqRules(final String field, final String op, final String data) {
		super();
		this.field = field;
		this.op = op;
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public String getField() {
		return field;
	}

	public String getOp() {
		return op;
	}

	public void setData(final String data) {
		this.data = data;
	}

	public void setField(final String field) {
		this.field = field;
	}

	public void setOp(final String op) {
		this.op = op;
	}
}
