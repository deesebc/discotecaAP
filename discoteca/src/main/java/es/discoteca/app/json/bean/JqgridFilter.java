package es.discoteca.app.json.bean;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JqgridFilter {

	@JsonProperty(value = "groupOp")
	private String groupOp;

	@JsonProperty(value = "rules")
	private List<JqRules> rules;

	public JqgridFilter() {
		super();
		rules = new ArrayList<JqRules>();
	}

	public JqgridFilter(final String groupOp, final List<JqRules> rules) {
		super();
		this.groupOp = groupOp;
		this.rules = rules;
	}

	public String getGroupOp() {
		return groupOp;
	}

	public List<JqRules> getRules() {
		return rules;
	}

	public void setGroupOp(final String groupOp) {
		this.groupOp = groupOp;
	}

	public void setRules(final List<JqRules> rules) {
		this.rules = rules;
	}

}
