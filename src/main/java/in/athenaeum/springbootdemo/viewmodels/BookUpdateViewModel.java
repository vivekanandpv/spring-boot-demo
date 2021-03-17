package in.athenaeum.springbootdemo.viewmodels;

public class BookUpdateViewModel {
    private long id;
    private double price;
    private int nPages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
