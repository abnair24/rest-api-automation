package slack;

import client.SlackClient;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import utils.Properties;
import utils.SlackWebHook;

public class SlackListner extends TestListenerAdapter {

    @Override
    public void onFinish(ITestContext testContext) {

        String slackChannel = Properties.SLACK_NOTIFICATION;
        String tags = Properties.TAGS;

        Reporter.log(slackChannel, true);
        Reporter.log(tags, true);
        if (!slackChannel.isEmpty()) {
            Reporter.log("Sending Notifications to slack", true);

            int pass = testContext.getPassedTests().size();
            int fail = testContext.getFailedTests().size();
            String status = fail > 0 || pass == 0 ? "#FF000" : "#36a000";

            Entities attachments = new SlackNotificationBuilder()
                    .withFallback(tags)
                    .withColor(status)
                    .withTitle("REST-API Automation Test Results", tags)
                    .withAuthorName("ABN")
                    .withPassValue(String.valueOf(pass))
                    .withFailedValue(String.valueOf(fail))
                    .build();

            Response response = new SlackClient().sendNotification(attachments, SlackWebHook.HOOKS.get(slackChannel));
            Reporter.log("Response: " + response.asString(), true);
            Reporter.log(String.format("%s", response.getStatusCode()), true);
        }
    }

}

