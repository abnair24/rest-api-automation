package utils;

public class Properties {

    public static final String SLACK_NOTIFICATION = null == System.getProperty("slackNotif") ? "" : System.getProperty("slackNotif");
    public static final String TAGS = null == System.getProperty("tag") ? "" : System.getProperty("tag");
    public static final String TOKEN = null == System.getProperty("token") ? "" : System.getProperty("token");
}
