package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StationArrival {
    private long stationId;
    private String direction;
    private long arrivalTime;
    private String name;

    public StationArrival(long stationId, String direction, long arrivalTime, String name) {
        this.setStationId(stationId);
        this.setDirection(direction);
        this.setArrivalTime(arrivalTime);
        this.setName(name);
    }
    @JsonProperty
    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }
    @JsonProperty
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    @JsonProperty
    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
