package mvc;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.ok;

/**
 *
 * @param <T>
 */
public class ApiResult<T> extends Result {

    private T payload;
    private int statusCode;

    public ApiResult() {
        super(-1);
    }

    public Result success(T payload) {
        this.statusCode = 200;
        this.payload = payload;
        JsonNode json = Json.toJson(this);
        return ok(json);
    }

    public T getPayload() {
        return payload;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
