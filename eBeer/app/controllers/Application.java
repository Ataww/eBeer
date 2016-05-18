package controllers;

import controllers.beer.BrewAPIAccess;
import play.mvc.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void status() {
        boolean status = BrewAPIAccess.isAlive();
        render(status);
    }

}