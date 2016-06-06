package controllers.job;

import models.Sale;
import play.Logger;
import play.jobs.Every;
import play.jobs.Job;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *     Scheduled task that periodically check sales that should be closed.
 * </p>
 * Created by couretn on 19/05/16.
 */
@Every("1mn")
public class ExpiredSalesJob extends Job {

    @Override
    public void doJob() {
        List<Sale> sales = Sale.find("select s from Sale s where s.expireDate is not null and s.expireDate < ?", Date.from(Instant.now())).fetch();
        Logger.info("found "+sales.size()+" sales expired");
        sales.forEach(s -> {s.setState(Sale.State.CLOSED); s.save();});
    }
}
