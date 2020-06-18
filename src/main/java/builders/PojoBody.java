package builders;

public class PojoBody {

    private String author, title;
    private int id;

    public PojoBody(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PojoBody{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }


}
