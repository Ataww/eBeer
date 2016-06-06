package controllers;

import controllers.security.CreateUserJob;
import models.User;
import play.libs.F;
import play.mvc.Controller;

/**
 * Created by couretn on 25/05/16.
 */
public class Profile extends Controller {

    public static void profile(String name) {
        User user = User.find("username",name).first();
        String username = session.get("username");
        if(user == null) {
            redirect("/");
        } else {
            render(user,username);
        }
    }
}
