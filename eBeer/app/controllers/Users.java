package controllers;

import play.mvc.With;

/**
 * Created by couretn on 19/05/16.
 */
@With(Secure.class)
public class Users extends CRUD {

}
