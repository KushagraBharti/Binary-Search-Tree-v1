public class Article {
    int id;
    String title;
    String author;

    // Constructor
    public Article(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // toString method to print the article details
    @Override
    public String toString() {
        return String.format("\t %d | %s | %s-->\n", id, title, author);
    }
}
