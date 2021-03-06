package controllers;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import controllers.beer.BrewAPIAccess;
import models.Beer;
import models.Sale;
import models.User;
import play.Logger;
import play.mvc.*;

public class Application extends Controller {

    public static void status() {
        boolean status = BrewAPIAccess.isAlive();
        String username = session.get("username");
        render(status,username);
    }

    public static void index() {
        List<Sale> recentSales = Sale.find("select s from Sale s where s.state = ? order by startDate desc",Sale.State.VALIDATED).fetch(10);
        String username = session.get("username");
        User user = User.find("username",username).first();
        Logger.info("Connected as user "+username);
        boolean status = BrewAPIAccess.isAlive();
        render(username,recentSales,user,status);
    }


	public static void beers() {
		List<Beer> beers = Beer.all().fetch();
		String username = session.get("username");
		render(username, beers);
	}

}