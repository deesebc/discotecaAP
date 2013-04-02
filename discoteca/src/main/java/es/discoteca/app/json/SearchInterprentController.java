/**
 * 
 */
package es.discoteca.app.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.discoteca.app.json.bean.InterpreteJson;
import es.discoteca.app.json.bean.JqGridRequest;
import es.discoteca.app.json.bean.JqGridResponse;
import es.discoteca.bbdd.bean.Disco;
import es.discoteca.bbdd.bean.Interprete;
import es.discoteca.bbdd.service.DiscoService;

/**
 * @author xe29197
 * 
 */
@Controller
public class SearchInterprentController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(SearchSongController.class);

	@Autowired
	private DiscoService service;

	@RequestMapping(value = "/jsonSearchSinger.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<InterpreteJson> records(@RequestBody final JqGridRequest jqGridRequest,
			final HttpServletRequest request, final HttpServletResponse response) {

		String id = "1";
		Disco disco = service.findById(Integer.valueOf(id));
		List<InterpreteJson> list2 = new ArrayList<InterpreteJson>();
		for (Interprete cancion : disco.getInterpretes()) {
			InterpreteJson bean = new InterpreteJson();
			bean.setNombre(cancion.getNombre());
			bean.setInstrumento(cancion.getInstrumento());
			bean.setIdent(Integer.toString(cancion.getIdent()));
			list2.add(bean);
		}
		JqGridResponse<InterpreteJson> exit = new JqGridResponse<InterpreteJson>();
		exit.setRows(list2);
		exit.setTotal(Integer.toString(list2.size()));
		exit.setPage("1");
		return exit;
	}
}
