package controllers.job;

import models.Sale;
import play.jobs.Every;
import play.jobs.Job;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * Created by couretn on 19/05/16.
 */
@Every("1mn")
public class ExpiredSalesJob extends Job {

    @Override
    public void doJob() {
        List<Sale> sales = Sale.all().fetch();
        sales.forEach(ExpiredSalesJob::updateExpiredJob);
    }

    private static void updateExpiredJob(Sale s) {
        if(LocalDate.now().isAfter(s.getExpireDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
            s.setState(Sale.State.CLOSED);
            s.save();
        }
    }
}
