package util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class ServiceResult<T> {

    private T payload;
    private int code;


    public ServiceResult(T payload, int code) {
        this.payload = payload;
        this.code = code;
    }

    public static ServiceResult of(Object payload) {
        return new ServiceResult(payload, 200);
    }

    public static ServiceResult notFound() {
        return new ServiceResult(null, 404);
    }

    public static ServiceResult internalError() {
        return new ServiceResult(null, 500);
    }

    public T getPayload() {
        return this.payload;
    }

    @JsonIgnore
    public boolean isOk() {
        return payload != null;
    }

    public int getCode() {
        return this.code;
    }

}