import java.net.URLEncoder;

import org.junit.Test;

public class URLEncoderTest {

	private static final String ENTITY_ID = "http://127.0.0.1:8080/spring-security-saml2-sample/saml/metadata";
	
	private static final String RELAY_STATE = "http://ISL-LTEGBERTB1.vha.med.va.gov:8080/spring-security-saml2-sample/login?disco=true&idp=MHV-IDP";
	
	@Test
	public void testURLEncoding() throws Exception {
		System.out.println(String.format("Encoded URL: http://local.myhealth.va.gov/c/portal/saml/sso?entityId=%s&RelayState=%s", URLEncoder.encode(ENTITY_ID, "UTF-8"), URLEncoder.encode(RELAY_STATE, "UTF-8")));
	}

}
