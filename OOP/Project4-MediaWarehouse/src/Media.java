import java.io.Serializable;

public class Media implements Serializable {
    /**
     * Auto generated serial UID.
     */
    private static final long serialVersionUID = 4852425220027718679L;

    /**
     * Universal Product Code of the media.
     */
    private String upc;

    /**
     * Title of the media.
     */
    private String title;

    /**
     * Year of release of the media.
     */
    private int year;

    /**
     * Price of the media.
     */
    private float price;

    /**
     * Basic constructor for Media.
     * 
     * @param upc   Universal Product Code of the media.
     * @param title Title of the media.
     * @param year  Year of release of the media.
     */
    public Media(String upc, String title, int year) {
        this.upc = upc;
        this.title = title;
        this.year = year;
    }

    /**
     * Basic constructor for Media that also initializes the price variable.
     * 
     * @param upc   Universal Product Code of the media.
     * @param title Title of the media.
     * @param year  Year of release of the media.
     * @param price Price of the Media
     */
    public Media(String upc, String title, int year, float price) {
        this(upc, title, year);
        setPrice(price);
    }

    /**
     * Basic get method for the upc variable.
     * 
     * @return the upc variable
     */
    public String getUpc() {
        return upc;
    }

    /**
     * Basic get method for the title variable.
     * 
     * @return the title variable
     */
    public String getTitle() {
        return title;
    }

    /**
     * Basic get method for the year variable.
     * 
     * @return the year variable
     */
    public int getYear() {
        return year;
    }

    /**
     * Basic get method for the price variable.
     * 
     * @return the price variable
     */
    public float getPrice() {
        return price;
    }

    /**
     * Basic setter method for the price variable.
     * 
     * @param rank The value the variable will be changed to.
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
