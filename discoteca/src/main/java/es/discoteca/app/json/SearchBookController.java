/**
 * 
 */
package es.discoteca.app.json;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.discoteca.app.json.bean.JqGridRequest;
import es.discoteca.app.json.bean.JqGridResponse;
import es.discoteca.app.json.bean.LibroJson;
import es.discoteca.bbdd.bean.Libro;
import es.discoteca.bbdd.service.LibroService;

/**
 * @author xe29197
 * 
 */
@Controller
public class SearchBookController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(SearchBookController.class);

	@Autowired
	private LibroService service;

	@Autowired
	private Mapper mapper;

	private void method(final String filter) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonFilter = mapper.readTree(filter);
		String groupOp = jsonFilter.get("groupOp").asText();
		LOGGER.debug("groupOp :" + groupOp);
		List<JsonNode> rules = jsonFilter.findValues("rules");
		LOGGER.debug("Count Rules :" + rules.size());
		for (JsonNode node : rules) {
			LOGGER.debug("field :" + node.get("field").asText());
			LOGGER.debug("op :" + node.get("op").asText());
			LOGGER.debug("data :" + node.get("data").asText());
		}
	}

	@RequestMapping(value = "/jsonSearchBook.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<LibroJson> records(@RequestBody final JqGridRequest jqGridRequest,
			final HttpServletRequest request, final HttpServletResponse response) {

		List<Libro> list = service.findAll();
		List<LibroJson> list2 = new ArrayList<LibroJson>();
		for (Libro disco : list) {
			LibroJson bean = mapper.map(disco, LibroJson.class);
			list2.add(bean);
		}
		JqGridResponse<LibroJson> exit = new JqGridResponse<LibroJson>();
		exit.setRows(list2);
		exit.setTotal(Integer.toString(list2.size()));
		exit.setPage("1");
		return exit;
	}
}
