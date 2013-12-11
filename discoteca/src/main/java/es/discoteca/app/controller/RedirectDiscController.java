/**
 * 
 */
package es.discoteca.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.home.almacen.bbdd.bean.Disco;
import es.home.almacen.bbdd.bean.Libro;
import es.home.almacen.bbdd.service.DiscoService;

/**
 * @author xe29197
 * 
 */
@Controller
public class RedirectDiscController {

	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	DiscoService service;
	
	@RequestMapping(value = "create/disc.htm")
	public ModelAndView createDisc(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {
		logger.info("RedirectBookController - createDisc");
		Disco disco = new Disco();
		ModelAndView model = new ModelAndView("edit.disc.page");
		model.addObject("disco", disco);
		return model;
	}

	@RequestMapping(value = "edit/disc.htm")
	public ModelAndView searchDisc(@RequestParam final String id, final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {

		logger.info("Pasamos por RedirectDiscController");
		Disco disco = service.findById(Integer.valueOf(id));
		ModelAndView model = new ModelAndView("edit.disc.page");
		model.addObject("disco", disco);

		return model;
	}
}
