package es.discoteca.test.properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.discoteca.app.constants.ConstansUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/conf/mvc-dispatcher-servlet-test.xml")
public class ConstantsUtilTest {

	private final Logger LOGGER = Logger.getLogger(ConstantsUtilTest.class);

	@Autowired
	private ConstansUtil utility;

	@Test
	public void getProperties() {
		try {
			String propertyGlobal = utility.getPropertyGlobal();
			String propertyProfile = utility.getPropertyProfile();
			if(propertyGlobal == null){
				Assert.fail();
			}else{
				LOGGER.info("propertyGlobal: "+propertyGlobal);
				LOGGER.info("propertyProfile: "+propertyProfile);
				Assert.assertTrue(true);
			}
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void getAppDebugMode() {
		try {
			String appDebugMode = utility.getAppDebugMode();
			if(appDebugMode == null){
				Assert.fail();
			}else{
				LOGGER.info("appDebugMode: "+appDebugMode);
				Assert.assertTrue(true);
			}
		} catch (final Exception except) {
			LOGGER.error("Error: ", except);
			Assert.assertTrue(false);
		}
	}
}
