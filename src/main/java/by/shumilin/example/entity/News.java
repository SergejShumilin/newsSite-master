package by.shumilin.example.entity;

public class News {
    private long id;
    private String title;
    private String content;
    private String shortText;

    public News() {
    }

    public News(long id, String title, String content, String shortText) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.shortText = shortText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", shortText='" + shortText + '\'' +
                '}';
    }
}
