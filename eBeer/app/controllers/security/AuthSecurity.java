package controllers.security;

import controllers.Secure;
import models.User;
import play.Logger;
import play.libs.Crypto;

/**
 * Created by Ataw on 21/05/2016.
 */
public class AuthSecurity extends Secure.Security {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    static boolean authenticate(String username, String password) {
        String encryptedPass = Crypto.encryptAES(password);
        User user = User.find("username",username).first();
        return user.getPassword().equals(encryptedPass);
    }
}
