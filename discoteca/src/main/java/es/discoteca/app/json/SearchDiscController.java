/**
 * 
 */
package es.discoteca.app.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.discoteca.app.json.bean.DiscoJson;
import es.discoteca.app.json.bean.JqGridResponse;
import es.discoteca.bbdd.bean.Disco;
import es.discoteca.bbdd.service.DiscoService;

/**
 * @author xe29197
 * 
 */
@Controller
public class SearchDiscController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(SearchDiscController.class);

	@Autowired
	private DiscoService service;

	@RequestMapping(value = "/jsonSearchDisc.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<DiscoJson> records(@RequestParam("_search") final Boolean search,
			@RequestParam(value = "filters", required = false) final String filters,
			@RequestParam(value = "page", required = false) final Integer page,
			@RequestParam(value = "rows", required = false) final Integer rows,
			@RequestParam(value = "sidx", required = false) final String sidx,
			@RequestParam(value = "sord", required = false) final String sord) {

		List<Disco> list = service.findAll();
		List<DiscoJson> list2 = new ArrayList<DiscoJson>();
		for (Disco disco : list) {
			DiscoJson bean = new DiscoJson();
			bean.setNombre(disco.getNombre());
			bean.setGrupo(disco.getGrupo());
			list2.add(bean);
		}
		JqGridResponse<DiscoJson> exit = new JqGridResponse<DiscoJson>();
		exit.setRows(list2);
		exit.setTotal(Integer.toString(list2.size()));
		exit.setPage("1");
		return exit;
	}
}
