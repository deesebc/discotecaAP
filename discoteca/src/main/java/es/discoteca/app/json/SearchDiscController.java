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

import es.discoteca.app.json.bean.DiscoJson;
import es.discoteca.app.json.bean.JqGridRequest;
import es.discoteca.app.json.bean.JqGridResponse;
import es.discoteca.app.util.PaginatorUtil;
import es.home.almacen.bbdd.bean.Disco;
import es.home.almacen.bbdd.service.DiscoService;

/**
 * @author xe29197
 * 
 */
@Controller
public class SearchDiscController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(SearchDiscController.class);

	@Autowired
	private DiscoService service;

	@Autowired
	private PaginatorUtil<Disco, DiscoJson> utility;

	private Page<Disco> getDisco(final String source, final Pageable pageable)
			throws JsonProcessingException, IOException {
		Page<Disco> exit = null;
		if (StringUtils.isBlank(source)) {
			exit = service.findSearchDiscs(null, null, pageable);
		} else {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonFilter = mapper.readTree(source);
			List<JsonNode> rules = jsonFilter.findValues("rules");
			String field, data, grupo = "", nombre = "";
			for (JsonNode node : rules) {
				field = node.findValues("field").get(0).asText();
				data = node.findValues("data").get(0).asText();
				if ("nombre".equals(field)) {
					nombre = data;
				} else if ("grupo".equals(field)) {
					grupo = data;
				}
			}

			exit = service.findSearchDiscs(nombre, grupo, pageable);

		}
		return exit;
	}

	@RequestMapping(value = "/jsonSearchDisc.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<DiscoJson> records(@RequestBody final JqGridRequest jqGridRequest,
			final HttpServletRequest request, final HttpServletResponse response) {

		JqGridResponse<DiscoJson> exit = new JqGridResponse<DiscoJson>();
		try {
			Pageable pageable = utility.getPageable(jqGridRequest);
			Page<Disco> page = getDisco(jqGridRequest.getFilters(), pageable);
			exit = utility.getBookJqGridRes(page, DiscoJson.class);
		} catch (Exception except) {
			exit.setError("Error en la busqueda: " + except.getMessage());
			LOGGER.error("Error en la busqueda: ", except);
		}
		return exit;
	}
}
