import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import org.quartz.Job;
import resources.StationResource;
import resources.SubscriptionResource;
import services.SubscriptionService;
import stores.SubscriptionStore;

public class MainApp extends Application<MainAppConfiguration> implements JobConfiguration {
    public static void main(String[] args) throws Exception {
        new MainApp().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<MainAppConfiguration> bootstrap) {
        Job subscriptionJob = new
        // nothing to do yet
    }

    @Override
    public void run(MainAppConfiguration configuration,
                    Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        final StationResource stationResource = new StationResource();
        environment.jersey().register(stationResource);

        final SubscriptionStore subscriptionStore = new SubscriptionStore(jdbi);
        final SubscriptionService subscriptionService = new SubscriptionService(subscriptionStore);
        final SubscriptionResource subscriptionResource = new SubscriptionResource(subscriptionService);

        environment.jersey().register(subscriptionResource);


    }

}