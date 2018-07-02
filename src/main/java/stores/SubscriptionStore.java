package stores;

import models.Subscription;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;

import java.util.List;

public class SubscriptionStore {
    private Jdbi jdbi;

    public SubscriptionStore(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Subscription> getSubscriptionsForUser(String userId) {
        final List<Subscription> subscriptionList;

        try(Handle handle = jdbi.open()) {
            handle.registerRowMapper(ConstructorMapper.factory(Subscription.class));
            return handle.createQuery("SELECT * FROM subscriptions where userId = :userId")
                    .bind("userId", userId)
                    .mapTo(Subscription.class)
                    .list();
        } catch(Exception e) {
            e.printStackTrace();
        }


        return null;
    }
    public List<Subscription> getSubscriptionsBetweenTimes(long startTime, long endTime) {
        final List<Subscription> subscriptionList;

        try(Handle handle = jdbi.open()) {
            handle.registerRowMapper(ConstructorMapper.factory(Subscription.class));
            List<Subscription> output =  handle.createQuery("SELECT * FROM subscriptions where startTime >= :startTime AND endTime <= :endTime")
                    .bind("startTime", startTime)
                    .bind("endTime", endTime)
                    .mapTo(Subscription.class)
                    .list();

            return output;
        } catch(Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
