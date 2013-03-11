/**
 * 
 */
package es.discoteca.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.discoteca.bbdd.bean.Disco;
import es.discoteca.bbdd.service.DiscoService;

/**
 * @author dsblanco
 * 
 */
@Controller
public class SaveDiscController {
	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoService service;

	@RequestMapping(value = "save/disc.htm")
	public ModelAndView searchDisc(@ModelAttribute("disco") final Disco form)
			throws ServletException, IOException {

		try {
			service.update(form);
		} catch (Exception except) {
			logger.error("Error al guardar el disco", except);
		}

		return new ModelAndView("search.disc.page");

	}
}
