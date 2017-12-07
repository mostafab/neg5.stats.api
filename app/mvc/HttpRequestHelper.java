package mvc;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Http;

/**
 * Http helper
 */
public class HttpRequestHelper {

    /**
     * Deserialize request to specified class
     * @param request Http Request
     * @return Deserialized json
     */
    public <A> A deserializeRequest(Http.Request request, Class<A> resultClass) {
        JsonNode requestJson = request.body().asJson();
        return Json.fromJson(requestJson, resultClass);
    }
}
