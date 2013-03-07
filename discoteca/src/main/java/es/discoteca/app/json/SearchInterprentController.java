/**
 * 
 */
package es.discoteca.app.json;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.discoteca.bbdd.service.InterpreteService;

/**
 * @author xe29197
 * 
 */
@Controller
public class SearchInterprentController implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(SearchInterprentController.class);

	@Autowired
	private InterpreteService service;

	@RequestMapping(value = "/initSI.htm")
	public ModelAndView handleRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("search.interprent.page");
	}
}
