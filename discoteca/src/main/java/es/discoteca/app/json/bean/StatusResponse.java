/**
 * 
 */
package es.discoteca.app.json.bean;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author dsblanco
 * 
 */
public class StatusResponse {

	@JsonProperty(value = "success")
	private Boolean success;
	@JsonProperty(value = "message")
	private final List<String> message;

	public StatusResponse() {
		message = new ArrayList<String>();
	}

	public StatusResponse(final Boolean success) {
		super();
		this.success = success;
		message = new ArrayList<String>();
	}

	public StatusResponse(final Boolean success, final List<String> message) {
		super();
		this.success = success;
		this.message = message;
	}

	public StatusResponse(final Boolean success, final String message) {
		super();
		this.success = success;
		this.message = new ArrayList<String>();
		this.message.add(message);
	}

}
