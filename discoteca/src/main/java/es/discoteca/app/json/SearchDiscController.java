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

	@Autowired
	private DiscoService service;

	@Autowired
	private PaginatorUtil<Disco, DiscoJson> utility;

	@RequestMapping(value = "/jsonSearchDisc.htm", produces = "application/json")
	public @ResponseBody
	JqGridResponse<DiscoJson> records(@RequestBody final JqGridRequest jqGridRequest,
			final HttpServletRequest request, final HttpServletResponse response) {

		Pageable pageable = utility.getPageable(jqGridRequest);
		Page<Disco> page = service.findAll(pageable);
		return utility.getBookJqGridRes(page, DiscoJson.class);
	}
}
