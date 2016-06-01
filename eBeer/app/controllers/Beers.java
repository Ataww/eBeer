package controllers;

import models.Beer;
import play.mvc.With;

/**
 * Created by couretn on 19/05/16.
 */
@With(Secure.class)
public class Beers extends CRUD {
	
	private static final int AUTOCOMPLETE_MAX = 10;

	public static void getBeersByName(final String term) {
	    renderJSON(Beer.findByName(term, AUTOCOMPLETE_MAX));
	}
}
