package controllers.job;

import models.Sale;
import play.jobs.Every;
import play.jobs.Job;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by couretn on 24/05/16.
 */
@Every("1mn")
public class ValidateSalesJob extends Job {

    @Override
    public void doJob() {
        List<Sale> sales = Sale.find("state", Sale.State.CREATED).fetch();
        sales.forEach(ValidateSalesJob::validateSale);
    }

    private static void validateSale(Sale s) {
        if (s.getExpireDate() != null && s.getExpireDate().before(Date.from(Instant.now())) || s.getQuantity() <= 0) {
            s.setState(Sale.State.CLOSED);
        }
        s.setStartDate(Date.from(Instant.now()));
        s.setState(Sale.State.VALIDATED);
        s.save();
    }
}
