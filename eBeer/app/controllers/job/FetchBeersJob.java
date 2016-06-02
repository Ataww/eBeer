package controllers.job;

import com.google.gson.*;

import controllers.beer.BrewAPIAccess;
import models.Beer;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class FetchBeersJob extends Job {

	@Override
	public void doJob() throws Exception {
		JsonArray ja = BrewAPIAccess.getAllBeers();
		for (JsonElement je : ja) {
			Beer beer = new Beer();
			beer.setName(je.getAsJsonObject().get("name").getAsString());
			beer.setBeerId(je.getAsJsonObject().get("id").getAsString());
			beer.save();
		}
	}

	
}
