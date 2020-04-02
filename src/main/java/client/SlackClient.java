package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import slack.Entities;
import utils.Helper;
import utils.Properties;

import static io.restassured.RestAssured.given;

public class SlackClient extends BaseClient {

    public Response sendNotification(Entities entities, String token) {

        String url = String.format("https://hooks.slack.com/services/%s", Properties.TOKEN);
        Reporter.log("URL :" + url, true);
        Reporter.log(String.format("\n Entities -- %s", Helper.getJson(entities)), true);

        RequestSpecification requestSpecification = given().contentType(ContentType.JSON).body(entities);
        return post(url, requestSpecification);
    }
}
