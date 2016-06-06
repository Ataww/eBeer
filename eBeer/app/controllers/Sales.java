package controllers;

import java.util.Date;

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
		render();
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
		validation.min("quantity", quantity, 0);
		validation.required("user", user);
		if(!validation.hasErrors())
			sale.save();
		render(user, beer, quantity);
	}

}
