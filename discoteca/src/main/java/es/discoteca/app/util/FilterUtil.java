/**
 * 
 */
package es.discoteca.app.util;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import es.home.almacen.bbdd.bean.Libro;

/**
 * @author xe29197
 * 
 */
public final class FilterUtil {

	private final static Logger LOGGER = Logger.getLogger(FilterUtil.class);

	public static Libro getLibro(final String source) throws JsonProcessingException, IOException {
		Libro book = new Libro();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonFilter = mapper.readTree(source);
		String groupOp = jsonFilter.get("groupOp").asText();
		LOGGER.debug("groupOp :" + groupOp);
		List<JsonNode> rules = jsonFilter.findValues("rules");
		LOGGER.debug("Count Rules :" + rules.size());
		String field, data;
		for (JsonNode node : rules) {
			field = node.get("field").asText();
			data = node.get("data").asText();
			if ("autor".equals(field)) {
				book.setAutor(data);
			} else if ("serie".equals(field)) {
				book.setSerie(data);
			} else if ("nombre".equals(field)) {
				book.setNombre(data);
			}
		}
		return book;
	}

	private FilterUtil() {
		super();
	}

}
