package com.neolynx.jersey.first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neolynx.pojo.SpringTestMessage;

//Sets the path to base URL + /hello
@Path("/hello")
public class SayHello {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return getMessage();
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + getMessage() + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + getMessage() + "</body></h1>" + "</html> ";
	}

	public String getMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springConfig.xml");
		SpringTestMessage bean = (SpringTestMessage) context
				.getBean("messageBean");

		return "Let the interesting times begin!!!" + "\n" + bean.sayHello();
	}

}
