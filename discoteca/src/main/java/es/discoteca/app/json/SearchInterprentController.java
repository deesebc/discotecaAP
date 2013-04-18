/**
 * 
 */
package es.discoteca.app.json;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.discoteca.app.json.bean.InterpreteJson;
import es.discoteca.app.json.bean.JqGridRequest;
import es.discoteca.app.json.bean.JqGridResponse;
import es.discoteca.app.util.PaginatorUtil;
import es.home.almacen.bbdd.bean.Interprete;
import es.home.almacen.bbdd.service.InterpreteService;

/**
 * @author xe29197
 * 
 */
@Controller
public class SearchInterprentController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(SearchInterprentController.class);

	@Autowired
	private InterpreteService service;

	@Autowired
	private PaginatorUtil<Interprete, InterpreteJson> utility;

	private Page<Interprete> getInterpretes(final String idDisco, final Pageable pageable)
			throws JsonProcessingException, IOException {
		return service.findAllByIdDisc(Integer.valueOf(idDisco), pageable);
	}

	@RequestMapping(value = "/jsonSearchSinger.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<InterpreteJson> records(@RequestBody final JqGridRequest jqGridRequest,
			@RequestParam final String id, final HttpServletRequest request,
			final HttpServletResponse response) {

		JqGridResponse<InterpreteJson> exit = new JqGridResponse<InterpreteJson>();
		try {
			Pageable pageable = utility.getPageable(jqGridRequest);
			Page<Interprete> page = getInterpretes(id, pageable);
			exit = utility.getBookJqGridRes(page, InterpreteJson.class);
		} catch (Exception except) {
			exit.setError("Error en la busqueda: " + except.getMessage());
			LOGGER.error("Error en la busqueda: ", except);
		}
		return exit;
	}
}
