package controllers.job;

import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;

/**
 * <p>
 *     For dev purpose only.
 * </p>
 * Created by couretn on 24/05/16.
 */
@OnApplicationStart
public class AdminCreateJob extends Job {

    @Override
    public void doJob() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(Crypto.encryptAES("admin"));
        admin.setEmail("admin@ebeer.com");
        admin.save();
    }
}
