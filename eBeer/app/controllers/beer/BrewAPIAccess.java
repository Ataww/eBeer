package controllers.beer;

import com.google.gson.JsonElement;

import play.libs.WS;

/**
 * Created by Ataw on 13/05/2016.
 */
public final class BrewAPIAccess {

    public static final String SERVICE_URL = "http://api.brewerydb.com/v2/";

    private static final String API_KEY = "9127482462bf1e2e65f934ad1d9bc30b";

    public static boolean isAlive() {
        WS.WSRequest request = WS.url(SERVICE_URL +"heartbeat");
        request.parameters.put("key", API_KEY);
        WS.HttpResponse res = request.get();
        if(res.success()) {
            return true;
        }
        return false;
    }
    
    public static JsonElement getAllBeers() {
    	WS.WSRequest request = WS.url(SERVICE_URL + "beers");
    	request.parameters.put("key", API_KEY);
    	request.parameters.put("abv", "0,20");
    	request.parameters.put("p", 1);
    	request.parameters.put("format", "json");
    	WS.HttpResponse res = request.get();
    	if(res.success()) {
    		return res.getJson();
    	}
    	return null;
    }
    
    public static JsonElement getBeerById(String id) {
    	WS.WSRequest request = WS.url(SERVICE_URL + "beer/" + id);
    	request.parameters.put("key", API_KEY);
    	request.parameters.put("format", "json");
    	WS.HttpResponse res = request.get();
    	if(res.success()) {
    		return res.getJson();
    	}
    	return null;
    }

}
