/**
 * 
 */
package es.discoteca.app.json;

import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.home.almacen.bbdd.service.DiscoService;

/**
 * @author dsblanco
 * 
 */
@Controller
public class ObtainListGroupNames {

	@Autowired
	private DiscoService service;

	@RequestMapping(value = "/jsonAutoCompleteGroupName.htm", produces = "application/json")
	public @ResponseBody
	TreeSet<String> records(final HttpServletRequest request, final HttpServletResponse response) {

		List<String> list = service.findAllGroupNames();
		return new TreeSet<String>(list);
	}

}
