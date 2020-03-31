package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import slack.Entities;

import static io.restassured.RestAssured.given;

public class SlackClient extends BaseClient {

    public Response sendNotification(Entities entities, String token) {
        String url = String.format("https://hooks.slack.com/services/%s",token);
        RequestSpecification requestSpecification = given().body(entities);
        return post(url,requestSpecification);
    }
}
