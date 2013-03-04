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
public class HelloController {
	protected final Logger logger = Logger.getLogger(getClass());

	@RequestMapping(value = "/hello.htm")
	public ModelAndView handleRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);

		return new ModelAndView("hello.page", "now", now);

	}
}
