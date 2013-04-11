/**
 * 
 */
package es.discoteca.app.json;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@Autowired
	private LibroService service;

	@Autowired
	private PaginatorUtil<Libro, LibroJson> utility;

	@RequestMapping(value = "/jsonSearchBook.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<LibroJson> records(@RequestBody final JqGridRequest jqGridRequest,
			final HttpServletRequest request, final HttpServletResponse response) {

		Pageable pageable = utility.getPageable(jqGridRequest);
		Page<Libro> page = service.findAll(pageable);
		return utility.getBookJqGridRes(page, LibroJson.class);
	}
}
