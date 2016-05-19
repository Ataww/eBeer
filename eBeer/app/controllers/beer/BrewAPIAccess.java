package controllers.beer;

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

}
