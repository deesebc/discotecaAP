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

import es.discoteca.bbdd.bean.Libro;
import es.discoteca.bbdd.service.LibroService;

/**
 * @author dsblanco
 * 
 */
@Controller
public class SaveBookController {
	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LibroService service;

	@RequestMapping(value = "save/book.htm")
	public ModelAndView searchDisc(@ModelAttribute("libro") final Libro form)
			throws ServletException, IOException {
		try {
			if (form.getIdent() == null) {
				service.create(form.getNombre(), form.getAutor(), form.getArgumento(),
						Integer.toString(form.getPaginas()));
			} else {
				service.update(form);
			}
		} catch (Exception except) {
			logger.error("Error al guardar el libro", except);
		}

		return new ModelAndView("search.book.page");
	}

}
