package slack;

import java.util.ArrayList;
import java.util.List;

public class SlackNotificationBuilder {

    private Entities entities;
    private List<Attachment> request;
    private List<Fields> fields;
    private Attachment attachment;
    private Fields passField, failedField;

    public SlackNotificationBuilder() {
        entities = new Entities();
        request = new ArrayList<>();
        fields = new ArrayList<>();
        attachment = new Attachment();
        passField = new Fields();
        failedField = new Fields();

        attachment.setPretext("Slack Notifications for Automation");
        attachment.setText("This repo is for API backend automation for Employee Service");
        attachment.setTitle("API Automation");
        attachment.setImage_url("https://unsplash.com/photos/VGR_ReUCqNw");
        attachment.setThumb_url("https://www.pinclipart.com/maxpin/iRJwbio/");
        attachment.setFooter("Slack API");
        attachment.setFooter_icon("https://platform.slack-edge.com/img/default_application_icon.png");

        passField.setTitle("Pass");
        passField.setShorta(true);
        failedField.setTitle("Failed");
        failedField.setShorta(true);
    }


    public SlackNotificationBuilder withFallback(String fallback) {
        attachment.setFallback(String.format("%s Tests", fallback));
        return this;
    }

    public SlackNotificationBuilder withColor(String color) {
        attachment.setColor(color);
        return this;
    }

    public SlackNotificationBuilder withAuthorName(String authorName) {
        attachment.setAuthor_name(authorName);
        return this;
    }

    public SlackNotificationBuilder withTitle(String url, String tags) {
        String title = String.format("<%s|%S> Tests", url, tags);
        attachment.setTitle(title);
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
        attachment.setFields(fields);
        request.add(attachment);
        entities.setAttachment(request);
        return entities;
    }
}


