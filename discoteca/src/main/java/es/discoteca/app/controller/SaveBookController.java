/**
 * 
 */
package es.discoteca.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.home.almacen.bbdd.bean.Libro;
import es.home.almacen.bbdd.service.LibroService;

/**
 * @author dsblanco
 * 
 */
@Controller
public class SaveBookController {
	protected final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LibroService service;
	
//	@InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new LibroValidator());
//    }

	@RequestMapping(value = "save/book.htm")
	public ModelAndView searchDisc(@Valid @ModelAttribute("libro")  final Libro form, BindingResult result)
			throws ServletException, IOException {
		try {
			if(result.hasErrors()){
				return new ModelAndView("edit.book.page");
			}else{
				if (form.getIdent() == null) {
					service.create(form);
				} else {
					service.update(form);
				}
			}
		} catch (Exception except) {
			logger.error("Error al guardar el libro", except);
		}

		return new ModelAndView("search.book.page");
	}

}
