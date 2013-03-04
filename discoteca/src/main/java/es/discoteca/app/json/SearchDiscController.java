/**
 * 
 */
package es.discoteca.app.json;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.discoteca.app.json.bean.DataTablesRequest;
import es.discoteca.app.json.bean.DataTablesResponse;
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

	@RequestMapping(value = "/jsonSearchDisc.htm", method = RequestMethod.POST)
	public @ResponseBody
	DataTablesResponse<Object> getData(@RequestBody final DataTablesRequest dtReq,
			final HttpServletResponse response) {

		List<Disco> list = service.findAll();
		for (Disco disco : list) {
			LOGGER.info("Disco name: " + disco.getNombre());
		}
		return new DataTablesResponse<Object>();
	}
}
