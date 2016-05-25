package controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import controllers.beer.BrewAPIAccess;
import play.mvc.*;

public class Application extends Controller {

	public static void status() {
		boolean status = BrewAPIAccess.isAlive();
		render(status);
	}
    public static void index() {
        if (session.contains("username")) {
            String username = session.get("username");
            render(username);
        } else {
            render();
        }
    }

	public static void testBeers() {
		JsonElement beersJson = BrewAPIAccess.getAllBeers();
		JsonObject jsonObject = beersJson.getAsJsonObject();
		JsonElement jsonElement = jsonObject.get("data");
		JsonArray jsonArray = jsonElement.getAsJsonArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonArray.get(i).getAsJsonObject().remove("style");
			jsonArray.get(i).getAsJsonObject().remove("nameDisplay");
			jsonArray.get(i).getAsJsonObject().remove("srm");
			jsonArray.get(i).getAsJsonObject().remove("glass");
			jsonArray.get(i).getAsJsonObject().remove("glasswareId");
			jsonArray.get(i).getAsJsonObject().remove("srmId");
			jsonArray.get(i).getAsJsonObject().remove("styleId");
			jsonArray.get(i).getAsJsonObject().remove("isOrganic");
			jsonArray.get(i).getAsJsonObject().remove("status");
			jsonArray.get(i).getAsJsonObject().remove("statusDisplay");
			jsonArray.get(i).getAsJsonObject().remove("createDate");
			jsonArray.get(i).getAsJsonObject().remove("updateDate");
		}
		renderJSON(jsonArray);
	}

}