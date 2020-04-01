package slack;

import java.util.ArrayList;
import java.util.List;

public class SlackNotificationBuilder {

    private Entities entities;
    private List<Attachments> request;
    private List<Fields> fields;
    private Attachments attachments;
    private Fields passField, failedField;

    public SlackNotificationBuilder() {
        entities = new Entities();
        request = new ArrayList<>();
        fields = new ArrayList<>();
        attachments = new Attachments();
        passField = new Fields();
        failedField = new Fields();

        attachments.setPretext("Slack Notifications for Automation");
        attachments.setText("This repo is for API backend automation for Employee Service");
        attachments.setThumb_url("https://images.unsplash.com/photo-1531214159280-079b95d26139?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80");
        attachments.setImage_url("https://www.pinclipart.com/picdir/big/340-3402688_thumbnail-image-tech-ontap-podcast-clipart.png");
        attachments.setFooter("Slack API");
        attachments.setFooter_icon("https://platform.slack-edge.com/img/default_application_icon.png");

        passField.setTitle("Pass");
        passField.setShorta(true);
        failedField.setTitle("Failed");
        failedField.setShorta(true);
    }


    public SlackNotificationBuilder withFallback(String fallback) {
        attachments.setFallback(String.format("%s Tests", fallback));
        return this;
    }

    public SlackNotificationBuilder withColor(String color) {
        attachments.setColor(color);
        return this;
    }

    public SlackNotificationBuilder withAuthorName(String authorName) {
        attachments.setAuthor_name(authorName);
        return this;
    }

    public SlackNotificationBuilder withTitle(String url, String tags) {
        String title = String.format("%s | %S ", url, tags);
        attachments.setTitle(title);
        return this;
    }

    public SlackNotificationBuilder withPassValue(String value) {
        passField.setValue(value);
        return this;
    }

    public SlackNotificationBuilder withFailedValue(String value) {
        failedField.setValue(value);
        return this;
    }

    public Entities build() {
        fields.add(passField);
        fields.add(failedField);
        attachments.setFields(fields);
        request.add(attachments);
        entities.setAttachments(request);
        return entities;
    }
}


