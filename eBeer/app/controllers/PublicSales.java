package controllers;

import java.util.List;

import models.Sale;

public class PublicSales extends CRUD {
	
	public static void showsales() {
		List<Sale> sales = Sale.all().fetch();
		String username = session.get("username");
		render(username, sales);
	}
}
