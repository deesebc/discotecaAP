/**
 * 
 */
package es.discoteca.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.home.almacen.bbdd.bean.Libro;

/**
 * @author daniel
 *
 */
@Component
public class LibroValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Libro.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serie", "serie.empty");
	}

	
	
//  Person p = (Person) obj;
//  if (p.getAge() < 0) {
//      e.rejectValue("age", "negativevalue");
//  } else if (p.getAge() > 110) {
//      e.rejectValue("age", "too.darn.old");
//  }
}
