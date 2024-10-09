import java.io.Serializable;
import java.util.Scanner;

public class Audio extends Media implements Comparable<Audio>, Serializable {
    /**
     * Auto generated serial UID.
     */
    private static final long serialVersionUID = 5367558304891137332L;

    /**
     * Billboard ranking of the audio.
     */
    private int billboardRank;

    /**
     * Is the audio operatic.
     */
    private boolean operatic;

    /**
     * format for toString method.
     */
    private static final String AUDIO_FORMAT = 
            "Audio\t%s\t%s\t%d\t%.2f\t%d\t%b";

    /**
     * Basic constructor for Audio.
     * 
     * @param upc   Universal Product Code of the audio.
     * @param title Title of the audio.
     * @param year  Year of release of the audio.
     */
    public Audio(String upc, String title, int year) {
        super(upc, title, year);
    }

    /**
     * Basic get method for the billboardRank variable.
     * 
     * @return the billboardRank variable
     */
    public int getBillboardRank() {
        return billboardRank;
    }

    /**
     * Basic setter method for the billboardRank variable.
     * 
     * @param rank The value the variable will be changed to.
     */
    public void setBillboardRank(int rank) {
        billboardRank = rank;
    }

    /**
     * Basic get method for the operatic variable.
     * 
     * @return the operatic variable
     */
    public boolean isOperatic() {
        return operatic;
    }

    /**
     * Basic setter method for the operatic variable.
     * 
     * @param rank The value the variable will be changed to.
     */
    public void setOperatic(boolean opera) {
        operatic = opera;
    }

    /**
     * Compares two Audio objects together based on rank, then price, then
     * title.
     */
    public int compareTo(Audio o) {
        if (billboardRank < o.getBillboardRank()) {
            return -1;
        } else if (billboardRank > o.getBillboardRank()) {
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
        return String.format(AUDIO_FORMAT, this.getUpc(), this.getTitle(),
                this.getYear(), this.getPrice(), this.getBillboardRank(),
                this.isOperatic());
    }

    /**
     * Creates a new Audio object, and initializes all variables, from a string
     * of data.
     * 
     * @param info The information to be made into a new object.
     * @return the newly created object
     */
    public static Audio load(String info) {
        Scanner in = new Scanner(info);
        in.useDelimiter("\t");
        in.next();
        Audio created = new Audio(in.next(), in.next(), in.nextInt());
        created.setPrice(in.nextFloat());
        created.setBillboardRank(in.nextInt());
        created.setOperatic(in.nextBoolean());
        in.close();
        return created;
    }
}
