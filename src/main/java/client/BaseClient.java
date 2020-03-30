package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClient {

    protected Response post(String url, RequestSpecification requestSpecification) {
        return requestSpecification
                .post(url);
    }

    protected Response get(String url, RequestSpecification requestSpecification) {
        return requestSpecification
                .get(url);
    }

    protected Response put(String url, RequestSpecification requestSpecification) {
        return requestSpecification
                .header("Content-Type", "application/json")
                .put(url);
    }

    protected Response delete(String url, RequestSpecification requestSpecification) {
        return requestSpecification
                .header("Content-Type","application/json")
                .delete(url);
    }
}
