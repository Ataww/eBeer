package controllers;

import models.User;
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
}
