package jobs;

import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;
import models.Subscription;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import services.SubscriptionService;

import java.util.List;

@Every("5s")
public class SubscriptionsJob extends Job {
    private SubscriptionService subscriptionsService;

    public void setSubscriptionsService(SubscriptionService service) {
        this.subscriptionsService = service;
    }

    @Override
    public void doJob(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if (subscriptionsService == null) {
            return;
        }

        System.out.println("running job");
        List<Subscription> subscriptionList = subscriptionsService.getSubscriptionsInTimeRange(String.valueOf(System.currentTimeMillis()/1000), String.valueOf(System.currentTimeMillis()/1000 + 1000));
        System.out.println(subscriptionList.size());
    }
}
