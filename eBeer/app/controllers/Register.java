package controllers;

import controllers.security.CreateUserJob;
import play.Logger;
import play.libs.F;
import play.mvc.Controller;

/**
 * <p>
 *     Controller handling the registering process of a user.
 * </p>
 * Created by Ataw on 22/05/2016.
 */
public class Register extends Controller {

	public static void signup() {
		render();
	}

	public static void register() {
		String username = params.get("username-field");
		String email = params.get("email-field");
		String password = params.get("password-field");
		F.Promise<Boolean> create = new CreateUserJob(email, username, password).now();
		Boolean created = await(create);
		render(created);
	}
}
