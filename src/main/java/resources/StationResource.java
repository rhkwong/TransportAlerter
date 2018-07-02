package resources;

import com.codahale.metrics.annotation.Timed;
import models.StationArrival;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class StationResource {

    public StationResource() {
    }

    @GET
    @Timed
    public StationArrival getStationArrival(@QueryParam("stationId") Optional<String> stationId) {
        return new StationArrival(123, "outbound", System.currentTimeMillis(), "Civic Center");
    }
}
