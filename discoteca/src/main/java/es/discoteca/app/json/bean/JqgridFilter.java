package es.discoteca.app.json.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class JqgridFilter {

	/**
	 * Inner class containing field rules
	 */
	public static class Rule {
		@JsonProperty(value = "junction")
		private String junction;
		@JsonProperty(value = "field")
		private String field;
		@JsonProperty(value = "op")
		private String op;
		@JsonProperty(value = "data")
		private String data;

		public Rule() {
		}

		public Rule(final String junction, final String field, final String op, final String data) {
			super();
			this.junction = junction;
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

		public String getJunction() {
			return junction;
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

		public void setJunction(final String junction) {
			this.junction = junction;
		}

		public void setOp(final String op) {
			this.op = op;
		}

	}

	@JsonProperty(value = "source")
	private String source;
	@JsonProperty(value = "groupOp")
	private String groupOp;

	@JsonProperty(value = "rules")
	private List<Rule> rules;

	public JqgridFilter() {
		super();
	}

	public JqgridFilter(final String source) {
		super();
		this.source = source;
	}

	public String getGroupOp() {
		return groupOp;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public String getSource() {
		return source;
	}

	public void setGroupOp(final String groupOp) {
		this.groupOp = groupOp;
	}

	public void setRules(final List<Rule> rules) {
		this.rules = rules;
	}

	public void setSource(final String source) {
		this.source = source;
	}

}
