
import java.io.Serializable;
import java.util.Scanner;

public class Video extends Media implements Serializable, Comparable<Video> {
    /**
     * Auto generated serial UID.
     */
    private static final long serialVersionUID = 3114087818132113465L;

    /**
     * Mpaa rating for the Video.
     */
    private String mpaa;

    /**
     * Whether the video is properly secured by HDCP.
     */
    private boolean hdcp;

    /**
     * format for toString method.
     */
    private static final String VIDEO_FORMAT = 
            "Video\t%s\t%s\t%d\t%.2f\t%s\t%b";

    /**
     * Basic constructor for Video.
     * 
     * @param upc   Universal Product Code of the video.
     * @param title Title of the video.
     * @param year  Year of release of the video.
     */
    public Video(String upc, String title, int year) {
        super(upc, title, year);
    }

    /**
     * Basic get method for the mpaa variable.
     * 
     * @return the mpaa variable
     */
    public String getMpaa() {
        return mpaa;
    }

    /**
     * Basic setter method for the mpaa variable.
     * 
     * @param rank The value the variable will be changed to.
     */
    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    /**
     * Basic get method for the hdcp variable.
     * 
     * @return the hdcp variable
     */
    public boolean isHdcp() {
        return hdcp;
    }

    /**
     * Basic setter method for the hdcp variable.
     * 
     * @param rank The value the variable will be changed to.
     */
    public void setHdcp(boolean opera) {
        hdcp = opera;
    }

    /**
     * Compares two Video objects together based on mpaa, then price, then
     * title.
     */
    public int compareTo(Video o) {
        if (mpaa.compareTo(o.getMpaa()) < 0) {
            return -1;
        } else if (mpaa.compareTo(o.getMpaa()) > 0) {
            return 1;
        }

        if (getPrice() < o.getPrice()) {
            return -1;
        } else if (getPrice() > o.getPrice()) {
            return 1;
        }

        if (getTitle().compareTo(o.getTitle()) < 0) {
            return -1;
        } else if (getTitle().compareTo(o.getTitle()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Converts the variables of the object into a string.
     */
    public String toString() {
        return String.format(VIDEO_FORMAT, this.getUpc(), this.getTitle(),
                this.getYear(), this.getPrice(), this.getMpaa(),
                this.isHdcp());
    }

    /**
     * Creates a new Video object, and initializes all variables, from a string
     * of data.
     * 
     * @param info The information to be made into a new object.
     * @return the newly created object
     */
    public static Video load(String info) {
        Scanner in = new Scanner(info);
        in.useDelimiter("\t");
        in.next();
        Video created = new Video(in.next(), in.next(), in.nextInt());
        created.setPrice(in.nextFloat());
        created.setMpaa(in.next());
        created.setHdcp(in.nextBoolean());
        in.close();
        return created;
    }
}
