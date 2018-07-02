package models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.beans.ConstructorProperties;

@JsonInclude
public class Subscription {
    private String id;
    private String stationId;
    private String userId;
    private String direction;
    private long startTime;
    private long endTime;

    @ConstructorProperties({"id", "stationId", "userId", "direction", "startTime", "endTime"})
    public Subscription(String id, String stationId, String userId, String direction, long startTime, long endTime) {
        this.id = id;
        this.stationId = stationId;
        this.userId = userId;
        this.direction = direction;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
