package controllers.job;

import models.Sale;
import play.jobs.Every;
import play.jobs.Job;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

/**
 * Created by couretn on 19/05/16.
 */
@Every("1mn")
public class ExpiredSalesJob extends Job {

    public void doJob() {
        List<Sale> sales = Sale.all().fetch();
        for(Sale s : sales) {
            if(LocalDate.now().isAfter(s.getExpireDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
                s.setState(Sale.State.CLOSED);
                s.save();
            }
        }
    }
}
