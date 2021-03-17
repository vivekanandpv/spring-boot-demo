package in.athenaeum.springbootdemo.viewmodels;

public class BookListViewModel {
    private String title;
    private String author;
    private double price;
    private int nPages;

    public BookListViewModel(
            String title,
            String author,
            double price,
            int nPages
    ) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.nPages = nPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
