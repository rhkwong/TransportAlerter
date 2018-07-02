package resources;

import com.codahale.metrics.annotation.Timed;
import models.Subscription;
import services.SubscriptionService;
import util.ServiceResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/subscription")
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {
    private SubscriptionService subscriptionService;

    public SubscriptionResource(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GET
    @Path("/id")
    @Timed
    public ServiceResult<Subscription> getStationArrival(@QueryParam("subscriptionId") Optional<String> subscriptionId) {
        if (!subscriptionId.isPresent()) {
            return null;
        }
        return ServiceResult.of(new Subscription(subscriptionId.get(),
                "1",
                "2",
                "north",
                System.currentTimeMillis(),
                System.currentTimeMillis() + 2));
    }

    @GET
    @Path("/for_userid")
    @Timed
    public ServiceResult<Subscription> getSubscriptionsForUser(@QueryParam("userid") Optional<String> userId) {
        if (!userId.isPresent()) {
            return null;
        }
        return ServiceResult.of(subscriptionService.getSubscriptionsForUser(userId.get()));
    }

    @GET
    @Path("/for_time")
    @Timed
    public ServiceResult<Subscription> getSubscriptionsForTimeRange(
            @QueryParam("startTime") Optional<String> startTime,
            @QueryParam("endTime") Optional<String> endTime
            ) {
        if (!startTime.isPresent() || !endTime.isPresent()) {
            return null;
        }
        return ServiceResult.of(subscriptionService.getSubscriptionsInTimeRange(startTime.get(), endTime.get()));
    }
}
