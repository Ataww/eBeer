package controllers.security;

import models.User;
import play.jobs.Job;
import play.libs.Crypto;

/**
 * Created by couretn on 25/05/16.
 */
public class CreateUserJob extends Job<Boolean>{

    private String password;
    private String email;
    private String username;

    public CreateUserJob(String email, String username, String password) {
        this.password = Crypto.encryptAES(password);
        this.email = email;
        this.username = username;
    }

    public Boolean doJobWithResult() {
        if(User.find("email",email).fetch().size() == 0 && User.find("username",username).fetch().size() == 0) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setUsername(username);
            user.save();
            return true;
        }
        return false;
    }
}
