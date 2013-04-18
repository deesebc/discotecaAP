/**
 * 
 */
package es.discoteca.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xe29197
 * 
 */
@Controller
public class MenuController {
	protected final Logger logger = Logger.getLogger(getClass());

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleAException(final ArithmeticException ex) {

		logger.info("handleAException - Catching: " + ex.getClass().getSimpleName());
		ModelAndView modelAndView = new ModelAndView("error.page");
		// modelAndView.setViewName("error.page");
		modelAndView.addObject("name", ex.getClass().getSimpleName());
		modelAndView.addObject("user", "Dani");

		return modelAndView;
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(final IOException ex) {

		logger.info("handleIOException - Catching: " + ex.getClass().getSimpleName());
		ModelAndView modelAndView = new ModelAndView("error.page");
		// modelAndView.setViewName("error.page");
		modelAndView.addObject("name", ex.getClass().getSimpleName());
		modelAndView.addObject("user", "Dani");

		return modelAndView;
	}

	@RequestMapping(value = "/search/disc.htm")
	public ModelAndView searchDisc(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {

		logger.info("Pasamos por MenuController");

		return new ModelAndView("search.disc.page");

	}

	@RequestMapping(value = "/search/book.htm")
	public ModelAndView searchInterprent(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException,
			ArithmeticException {

		logger.info("Pasamos por MenuController");
		// boolean throwException = true;

		// if (throwException) {
		// // throw new IOException("This is my IOException");
		// logger.info(1 / 0);
		// }
		return new ModelAndView("search.book.page");

	}
}
