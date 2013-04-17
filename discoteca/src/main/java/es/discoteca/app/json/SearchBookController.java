/**
 * 
 */
package es.discoteca.app.json;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.discoteca.app.json.bean.JqGridRequest;
import es.discoteca.app.json.bean.JqGridResponse;
import es.discoteca.app.json.bean.LibroJson;
import es.discoteca.app.util.PaginatorUtil;
import es.home.almacen.bbdd.bean.Libro;
import es.home.almacen.bbdd.service.LibroService;

/**
 * @author xe29197
 * 
 */
@Controller
public class SearchBookController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(SearchBookController.class);

	@Autowired
	private LibroService service;

	@Autowired
	private PaginatorUtil<Libro, LibroJson> utility;

	private Page<Libro> getLibro(final String source, final Pageable pageable)
			throws JsonProcessingException, IOException {
		Page<Libro> exit = null;
		if (StringUtils.isBlank(source)) {
			exit = service.findSearchBooks(null, null, null, pageable);
		} else {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonFilter = mapper.readTree(source);
			List<JsonNode> rules = jsonFilter.findValues("rules");
			String field, data, autor = "", nombre = "", serie = "";
			for (JsonNode node : rules) {
				field = node.findValues("field").get(0).asText();
				data = node.findValues("data").get(0).asText();
				if ("autor".equals(field)) {
					autor = data;
				} else if ("serie".equals(field)) {
					serie = data;
				} else if ("nombre".equals(field)) {
					nombre = data;
				}
			}

			exit = service.findSearchBooks(nombre, autor, serie, pageable);

		}
		return exit;
	}

	@RequestMapping(value = "/jsonSearchBook.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<LibroJson> records(@RequestBody final JqGridRequest jqGridRequest,
			final HttpServletRequest request, final HttpServletResponse response) {
		Page<Libro> page = null;
		try {
			Pageable pageable = utility.getPageable(jqGridRequest);
			page = getLibro(jqGridRequest.getFilters(), pageable);
		} catch (Exception except) {
			LOGGER.error("Error en la busqueda: ", except);
		}
		return utility.getBookJqGridRes(page, LibroJson.class);
	}
}
