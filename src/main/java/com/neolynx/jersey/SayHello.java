package com.neolynx.jersey;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.neolynx.business.UserService;
import com.neolynx.domain.SpringTestMessage;
import com.neolynx.domain.impl.User;

//Sets the path to base URL + /hello
@Path("/test/hello")
public class SayHello {

	Gson gsonObject = new Gson();

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return getMessage();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJSONHello() {
		User user1 = new User(1L, "niteshgarg@gmail.com", "password", new Date(), new Date(), "System");
		return gsonObject.toJson(user1, User.class);
	}

	public String getMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		SpringTestMessage bean = (SpringTestMessage) context.getBean("messageBean");

		@SuppressWarnings("unchecked")
		UserService<User> userService = (UserService<User>) context.getBean("userService");

		User user1 = new User(1L, "niteshgarg@gmail.com", "password", new Date(), new Date(), "System");
		User user2 = new User(2L, "monika.aggs@gmail.com", "password", new Date(), new Date(), "System");

		System.out.println("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: " + userService.get(user1));
		System.out.println("User is not in redis yet: " + userService.get(user2));

		System.out.println("==== putting objects into redis ====");
		userService.put(user1);
		userService.put(user2);

		System.out.println("==== getting objects from redis ====");
		System.out.println("User should be in redis yet: " + userService.get(user1));
		System.out.println("User should be in redis yet: " + userService.get(user2));

		System.out.println("==== deleting objects from redis ====");
		userService.delete(user1);
		userService.delete(user2);

		System.out.println("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: " + userService.get(user1));
		System.out.println("User is not in redis yet: " + userService.get(user2));

		return "Let the interesting times begin!!!\n" + bean.sayHello();
	}

}
