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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xe29197
 * 
 */
@Controller
public class MenuController {
	protected final Logger logger = Logger.getLogger(getClass());

	@RequestMapping(value = "/search/disc.htm")
	public ModelAndView searchDisc(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {

		logger.info("Pasamos por MenuController");

		return new ModelAndView("search.disc.page");

	}

	@RequestMapping(value = "/search/book.htm")
	public ModelAndView searchInterprent(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {

		logger.info("Pasamos por MenuController");

		return new ModelAndView("search.book.page");

	}
}
