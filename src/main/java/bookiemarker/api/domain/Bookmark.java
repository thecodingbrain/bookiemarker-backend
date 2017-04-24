package bookiemarker.api.domain;

import javax.persistence.*;

@Entity
public class Bookmark
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String url;

    @Column(columnDefinition = "Text")
    private String summary = "";

    private String title = "";

    private String thumbnail = "100x100.png";

    public String getSummary() {

        return summary;
    }

    public void setSummary(String summary) {

        this.summary = summary;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getThumbnail() {

        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {

        this.thumbnail = thumbnail;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }
}
