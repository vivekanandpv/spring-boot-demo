package in.athenaeum.springbootdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String category;
    private String author;
    private double price;
    private int nPages;

    public Book() {
    }

    public Book(
            long id,
            String title,
            String category,
            String author,
            double price,
            int nPages
    ) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.price = price;
        this.nPages = nPages;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getnPages() {
        return nPages;
    }

    public void setnPages(int nPages) {
        this.nPages = nPages;
    }
}
