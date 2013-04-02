/**
 * 
 */
package es.discoteca.app.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.discoteca.app.json.bean.StatusResponse;
import es.discoteca.bbdd.bean.Cancion;
import es.discoteca.bbdd.bean.Disco;
import es.discoteca.bbdd.bean.Interprete;
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

	@RequestMapping(value = "/jsonAddSinger.htm", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody
	StatusResponse addInterpretent(@RequestParam final String nombre,
			@RequestParam final String instrumento, @RequestParam final String idDisco)
			throws ServletException, IOException {
		boolean success = true;
		try {
			Disco bean = service.findById(Integer.valueOf(idDisco));
			Interprete interprete = new Interprete();
			interprete.setInstrumento(instrumento);
			interprete.setIdent(null);
			interprete.setNombre(nombre);
			bean.getInterpretes().add(interprete);
			service.update(bean);
		} catch (Exception except) {
			success = false;
			logger.error("Error al guardar el interprete", except);
		}

		return new StatusResponse(success);
	}

	@RequestMapping(value = "/jsonAddSong.htm", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody
	StatusResponse addSong(@RequestParam final String nombre, @RequestParam final String duracion,
			@RequestParam final String posicion, @RequestParam final String idDisco)
			throws ServletException, IOException {
		boolean success = true;
		try {
			Disco bean = service.findById(Integer.valueOf(idDisco));
			Cancion cancion = new Cancion();
			cancion.setDuracion(duracion);
			cancion.setIdent(null);
			cancion.setNombre(nombre);
			cancion.setPosicion(Integer.valueOf(posicion));
			bean.getCanciones().add(cancion);
			service.update(bean);
		} catch (Exception except) {
			success = false;
			logger.error("Error al guardar el disco", except);
		}

		return new StatusResponse(success);
	}

	@RequestMapping(value = "/jsonDeleteSinger.htm", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody
	StatusResponse deleteInterpretent(@RequestParam final String id,
			@RequestParam final String idDisco) throws ServletException, IOException {
		boolean success = true;
		try {
			Disco bean = service.findById(Integer.valueOf(idDisco));
			Iterator<Interprete> iterator = bean.getInterpretes().iterator();
			boolean enc = false;
			while (iterator.hasNext() && !enc) {
				if (iterator.next().getIdent().equals(Integer.valueOf(id))) {
					iterator.remove();
					enc = true;
				}
			}
			service.update(bean);
		} catch (Exception except) {
			success = false;
			logger.warn("Id interprete: " + id, except);
			logger.warn("Id disco: " + idDisco, except);
			logger.error("Error al borrar el interprete", except);
		}

		return new StatusResponse(success);
	}

	@RequestMapping(value = "/jsonDeleteSong.htm", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody
	StatusResponse deleteSong(@RequestParam final String id, @RequestParam final String idDisco)
			throws ServletException, IOException {
		boolean success = true;
		try {
			Disco bean = service.findById(Integer.valueOf(idDisco));
			Iterator<Cancion> iterator = bean.getCanciones().iterator();
			boolean enc = false;
			while (iterator.hasNext() && !enc) {
				if (iterator.next().getIdent().equals(Integer.valueOf(id))) {
					iterator.remove();
					enc = true;
				}
			}
			service.update(bean);
		} catch (Exception except) {
			success = false;
			logger.warn("Id cancion: " + id, except);
			logger.warn("Id disco: " + idDisco, except);
			logger.error("Error al borrar la cancion", except);
		}

		return new StatusResponse(success);
	}

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
