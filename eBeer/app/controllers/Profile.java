package controllers;

import controllers.security.CreateUserJob;
import models.User;
import play.libs.F;
import play.mvc.Controller;

/**
 * Created by couretn on 25/05/16.
 */
public class Profile extends Controller {

    public static void profile(String username) {
        User user = User.find("username",username).first();
        if(user == null) {
            redirect("/");
        } else {
            render(user);
        }
    }

    public static void edit(String username) {
        User user = User.find("username",username).first();
        String sessionUser = session.get("username");
        if(user == null) {
            redirect("/");
        } else if(sessionUser != username) {
            profile(username);
        } else {
            render(user);
        }
    }

    public static void submit() {
        String email = params.get("email-field");
        String password = params.get("password-field");

    }
}
