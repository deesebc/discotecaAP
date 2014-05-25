package es.discoteca.app.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    protected final Logger logger = Logger.getLogger(getClass());

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleAException(final ArithmeticException ex) {

	logger.info("handleAException - Catching: " + ex.getClass().getSimpleName());
	ModelAndView modelAndView = new ModelAndView("error.page");
	modelAndView.addObject("exception", ex.getClass().getSimpleName());

	String name = SecurityContextHolder.getContext().getAuthentication().getName();
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	logger.info("username: " + userDetails.getUsername());
	modelAndView.addObject("user", name);

	return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(final Exception ex) {

	logger.info("handleIOException - Catching: " + ex.getClass().getSimpleName());
	ModelAndView modelAndView = new ModelAndView("error.page");
	modelAndView.addObject("exception", ex.getClass().getSimpleName());
	modelAndView.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());

	return modelAndView;
    }

    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(final IOException ex) {

	logger.info("handleIOException - Catching: " + ex.getClass().getSimpleName());
	ModelAndView modelAndView = new ModelAndView("error.page");
	modelAndView.addObject("exception", ex.getClass().getSimpleName());
	modelAndView.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());

	return modelAndView;
    }
}
