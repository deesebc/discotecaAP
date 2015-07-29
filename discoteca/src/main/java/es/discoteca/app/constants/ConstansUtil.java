package es.discoteca.app.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstansUtil {

	@Value("${app.debug.mode}") 
    private String appDebugMode;
	@Value("${property.profile}") 
    private String propertyProfile;
	@Value("${property.global}") 
    private String propertyGlobal;

	public String getPropertyProfile() {
		return propertyProfile;
	}

	public void setPropertyProfile(String propertyProfile) {
		this.propertyProfile = propertyProfile;
	}

	public String getPropertyGlobal() {
		return propertyGlobal;
	}

	public void setPropertyGlobal(String propertyGlobal) {
		this.propertyGlobal = propertyGlobal;
	}

	public String getAppDebugMode() {
		return appDebugMode;
	}

	public void setAppDebugMode(String appDebugMode) {
		this.appDebugMode = appDebugMode;
	}
	
	
}


