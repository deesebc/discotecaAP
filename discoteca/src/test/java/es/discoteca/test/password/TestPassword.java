package es.discoteca.test.password;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPassword {

    private static final Logger LOGGER = Logger.getLogger(TestPassword.class);

    @Test
    public void metodo() {
	try {
	    String password = "admin";
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(password);
	    LOGGER.info("encodedPassword: " + encodedPassword);
	} catch (Exception except) {
	    LOGGER.error("Error al parsear", except);
	    Assert.assertTrue(false);
	}
    }

}
