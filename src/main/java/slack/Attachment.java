package slack;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Attachment {

    public String fallback;
    public String color;
    public String pretext;
    public String author_name;
    public String author_link;
    public String author_icon;
    public String title;
    public String text;
    public List<Fields> fields;
    public String image_url;
    public String thumb_url;
    public String footer;
    public String footer_icon;
}
