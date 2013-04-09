/**
 * 
 */
package es.discoteca.test.json;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import es.discoteca.app.json.bean.JqRules;
import es.discoteca.app.json.bean.JqgridFilter;

/**
 * @author xe29197
 * 
 */
public class TestJson {

	private static final Logger LOGGER = Logger.getLogger(TestJson.class);

	@Test
	public void metodo2() {
		try {
			ObjectMapper mapper = new ObjectMapper();

			String jsonString = "\"{\"groupOp\":\"AND\",\"rules\":[{\"field\":\"nombre\",\"op\":\"cn\",\"data\":\"n2\"}]}\"";
			JqgridFilter objeto = mapper.readValue(jsonString, JqgridFilter.class);
			LOGGER.info("Info :" + objeto);
		} catch (Exception except) {
			LOGGER.error("Error al parsear", except);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void metodo3() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JqgridFilter objeto = new JqgridFilter();
			objeto.setGroupOp("AND");
			objeto.getRules().add(new JqRules("nombre", "cn", "n2"));
			String jsonString = mapper.writeValueAsString(objeto);
			LOGGER.info("Info :" + jsonString);
		} catch (Exception except) {
			LOGGER.error("Error al parsear", except);
			Assert.assertTrue(false);
		}
	}
}
