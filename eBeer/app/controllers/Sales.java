package controllers;

import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;

import controllers.beer.BrewAPIAccess;
import models.Beer;
import models.Sale;
import models.Sale.State;
import models.User;
import play.mvc.With;

/**
 * Created by couretn on 19/05/16.
 */
@With(Secure.class)
public class Sales extends CRUD {

	public static void createsale() {
		String username = session.get("username");
		render(username);
	}

	public static void submitsale() {
		Sale sale = new Sale();
		String beername = params.get("beername-field");
		int quantity = Integer.parseInt(params.get("quantity-field"));
		Beer beer = Beer.find("Name", beername).first();
		String username = session.get("username");
		User user = User.find("username", username).first();
		sale.setProduct(beer);
		sale.setQuantity(quantity);
		sale.setStartDate(new Date());
		sale.setState(State.CREATED);
		sale.setSeller(user);
		validation.required("beer", beer);
		validation.min("quantity", quantity, 1);
		validation.required("user", user);
		if (!validation.hasErrors())
			sale.save();
		render(username, beer, quantity);
	}

	public static void showsale(long id) {
		String username = session.get("username");
		Sale sale = Sale.find("Id", id).first();
		Beer beer = sale.getProduct();
		JsonObject jsonObject = BrewAPIAccess.getBeerById(beer.getBeerId()).getAsJsonObject();
		String abv = jsonObject.get("abv") == null ? "" : jsonObject.get("abv").getAsString();
		String description = jsonObject.get("description") == null ? "" : jsonObject.get("description").getAsString();
		boolean saleValidated = sale.getState() == State.VALIDATED;
		render(username, sale, abv, description, saleValidated);
	}

	public static void buy(long id) {
		boolean success = false;
		String username = session.get("username");
		Sale sale = Sale.find("Id", id).first();
		if (sale != null && !(sale.getState() == State.COMPLETED)) {
			sale.setState(State.COMPLETED);
			sale.save();
			success = true;
		}
		render(username, success);
	}
}
