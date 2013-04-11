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

import es.home.almacen.bbdd.bean.Libro;
import es.home.almacen.bbdd.service.LibroService;

/**
 * @author xe29197
 * 
 */
@Controller
public class RedirectBookController {

	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	LibroService service;

	@RequestMapping(value = "create/book.htm")
	public ModelAndView createBook(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {
		logger.info("RedirectBookController - createBook");
		Libro libro = new Libro();
		ModelAndView model = new ModelAndView("edit.book.page");
		model.addObject("libro", libro);
		return model;
	}

	@RequestMapping(value = "delete/book.htm")
	public ModelAndView deleteBook(@RequestParam final String id, final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {
		logger.info("RedirectBookController - deleteBook");
		Libro disco = service.findById(Integer.valueOf(id));
		service.remove(disco);
		ModelAndView model = new ModelAndView("search.book.page");
		return model;
	}

	@RequestMapping(value = "edit/book.htm")
	public ModelAndView editBook(@RequestParam final String id, final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {
		logger.info("RedirectBookController - editBook");
		Libro libro = service.findById(Integer.valueOf(id));
		ModelAndView model = new ModelAndView("edit.book.page");
		model.addObject("libro", libro);

		return model;
	}
}
