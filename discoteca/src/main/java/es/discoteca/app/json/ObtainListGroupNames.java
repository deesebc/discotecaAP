/**
 * 
 */
package es.discoteca.app.json;

import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.home.almacen.bbdd.bean.Disco;
import es.home.almacen.bbdd.service.DiscoService;

/**
 * @author dsblanco
 * 
 */
@Controller
public class ObtainListGroupNames {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(ObtainListGroupNames.class);

	@Autowired
	private DiscoService service;

	@RequestMapping(value = "/jsonAutoCompleteGroupName.htm", produces = "application/json")
	public @ResponseBody
	TreeSet<String> records(final HttpServletRequest request, final HttpServletResponse response) {

		List<Disco> list = service.findAll();
		TreeSet<String> exit = new TreeSet<String>();
		for (Disco disco : list) {
			exit.add(disco.getGrupo());
		}
		return exit;
	}

}
