package controllers;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import controllers.beer.BrewAPIAccess;
import models.Beer;
import play.mvc.*;

public class Application extends Controller {

    public static void status() {
        boolean status = BrewAPIAccess.isAlive();
        String username = session.get("username");
        render(status,username);
    }

    public static void index() {
        String username = session.get("username");
        render(username);
    }


	public static void beers() {
		List<Beer> beers = Beer.all().fetch();
		render(beers);
	}

}