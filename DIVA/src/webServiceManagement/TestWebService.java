package webServiceManagement;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService
public class TestWebService {
	
	int id = 10;
	
	@Resource
	WebServiceContext context;
	
	@WebMethod
	public int getID() throws Exception {
		if (context.isUserInRole("customer")) {
			return this.id;
		}
		else {
			throw new Exception("Don't Use This Method, you are not a customer");
		}
	}
}
