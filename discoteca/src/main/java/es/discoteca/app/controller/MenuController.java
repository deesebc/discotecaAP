/**
 * 
 */
package es.discoteca.app.controller;

import java.io.IOException;
import java.util.Date;

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

	@RequestMapping(value = "/accessdenied.htm")
	public ModelAndView accessDenied(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		logger.info("accessDenied - init");
		return new ModelAndView("access.denied.page");

	}

	@RequestMapping(value = "/hello.htm")
	public ModelAndView hello(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		logger.info("hello - init");
		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);

		return new ModelAndView("hello.page", "now", now);

	}

	@RequestMapping(value = "/search/book.htm")
	public ModelAndView searchBook(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException, ArithmeticException {
		logger.info("searchBook - init");
		// boolean throwException = true;
		// if (throwException) {
		// throw new IOException("This is my IOException");
		// logger.info(1 / 0);
		// }
		return new ModelAndView("search.book.page");

	}

	@RequestMapping(value = "/search/disc.htm")
	public ModelAndView searchDisc(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		logger.info("searchDisc - init");
		return new ModelAndView("search.disc.page");

	}
}
