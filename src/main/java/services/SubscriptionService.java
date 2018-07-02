package services;

import models.Subscription;
import stores.SubscriptionStore;

import java.sql.DriverManager;
import java.util.List;

public class SubscriptionService {
    private SubscriptionStore subscriptionStore;

    public SubscriptionService(SubscriptionStore subscriptionStore) {
        this.subscriptionStore = subscriptionStore;
    }

    public List<Subscription> getSubscriptionsForUser(String userId) {
        List<Subscription> result = subscriptionStore.getSubscriptionsForUser(userId);

        return result;
    }

    public List<Subscription> getSubscriptionsInTimeRange(String startTime, String endTime) {
        List<Subscription> result = subscriptionStore.getSubscriptionsBetweenTimes(Long.parseLong(startTime), Long.parseLong(endTime));

        return result;
    }
}
