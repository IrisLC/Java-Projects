import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class acts as a warehouse that maintains the list of media items Media
 * items can be added, searched, and priced.
 */
public class MediaWarehouse {
    /**
     * The list of media currently available in this warehouse. This list is
     * initialized to an empty list in the constructor.
     */
    private ArrayList<Media> mediaList;

    /**
     * The default constructor merely initializes the instance variables.
     */
    public MediaWarehouse() {
        mediaList = new ArrayList<>();
    }

    /**
     * Helper method to find the media object associated with a given upc in the
     * mediaList.
     * 
     * @param upc The UPC to search for in the current mediaList.
     * @return This method returns the media item if it is found. Otherwise,
     *         this method returns null.
     */
    public Media findMedia(String upc) {
        for (Media m : mediaList) {
            if (m.getUpc().equals(upc)) {
                return m;
            }
        }

        return null; // when media with given upc not found.
    }

    /**
     * Print the list of media in the mediaList.
     */
    public void printMedia() {
        System.out.println("Currently loaded media:\n");

        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }

    /**
     * Searches for the given phrase in each media's UPC and title. The method
     * prints the media objects that contain the phrase. This method also prints
     * a summary message of the form -- "Found 5 matches, out of 17 media
     * items." at the end. See sample outputs in project document for more
     * examples.
     * 
     * @note The search is case-insensitive. So all strings must be first
     *       converted to lower case prior to using them.
     * 
     * @param phrase The substring to search for.
     */
    public void search(String phrase) {
        // Convert sub-name to lower case to streamline the search
        phrase = phrase.toLowerCase();
        int count = 0;
        System.out.println("Media with the phrase are:");
        for (Media m : mediaList) {
            if (m.getUpc().contains(phrase)
                    || m.getTitle().toLowerCase().contains(phrase)) {
                count++;
                System.out.println(m.toString());
            }
        }

        System.out.println("Found " + count + " matches, out of "
                + mediaList.size() + " media items.");
    }

    /**
     * This method is called to load data from either a text file or a binary
     * file. For text file formats see 90s_media.txt for example. The binary
     * file is read as a single object (using an ObjectInputStream) of ArrayList
     * type. The media loaded is added to the mediaList instance variable in
     * this class. This method does not add duplicate media items -- i.e. media
     * with the same UPC are duplicates. If a duplicate media item is found it
     * prints an message stating with the duplicate upc in the form --
     * "Duplicate media with upc m_90_2 ignored".
     * 
     * @see Video.load
     * @see Audio.load
     * 
     * @note It may be best to create a helper method that checks and adds
     *       non-duplicate media.
     * 
     * @param filePath Path (relative or absolute) to the file from where the
     *                 media is to be added to the current
     * @param isText   If this flag is true, then the file is a text file.
     *                 Otherwise the file is a binary file (created via prior
     *                 call to the writeMedia method in this class.
     * 
     * @return This method returns the number of new media items added from the
     *         file.
     * 
     * @throws IOException            When I/O errors occur
     * @throws ClassNotFoundException When loading binary media object fails
     */
    public int addMediaFrom(String filePath, boolean isText)
            throws IOException, ClassNotFoundException {
        int counter = 0;
        if (isText) {
            Scanner in = new Scanner(new File(filePath)),
                    reader = new Scanner(new File(filePath));
            in.useDelimiter("\t");
            while (in.hasNextLine()) {
                Media input = typeChecker(in, reader);

                in.nextLine();
                counter += duplicateChecker(input);
            }

        } else {
            ArrayList<Media> list = new ArrayList<Media>();
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filePath))) {
                list = (ArrayList<Media>) ois.readObject();

                for (int i = 0; i < list.size(); i++) {
                    counter += duplicateChecker(list.get(i));
                }
            }
        }

        return counter;
    }

    /**
     * A helper method for addMediaFrom() that takes Scanners reading a text
     * file, and creates either an Audio or Video object based off of the
     * contents.
     * 
     * @param in     The Scanner object that will check the first word of the
     *               file to determine what kind of object it is
     * @param reader The Scanner object that will read the entire line of the
     *               file to create the new object
     * @return the Media object created
     */
    private Media typeChecker(Scanner in, Scanner reader) {
        Media input;
        if (in.next().equals("Audio")) {
            input = Audio.load(reader.nextLine());
        } else {
            input = Video.load(reader.nextLine());
        }

        return input;
    }

    /**
     * A helper method for addMediaFrom() that checks if an object's upc already
     * appears in an ArrayList.
     * 
     * @param input the object being checked
     * @return 0 or 1, determines if the counter for the number of files loaded
     *         will increase
     */
    private int duplicateChecker(Media input) {
        int counter = 0;
        boolean duplicate = false;

        for (Media m : mediaList) {
            if (m.getUpc().equals(input.getUpc())) {
                duplicate = true;
                break;
            }
        }

        if (!duplicate) {
            mediaList.add(input);
            counter++;
        } else {
            System.out.println(
                    "Duplicate media with upc " + input.getUpc() + " ignored.");
        }

        return counter;
    }

    /**
     * This method is called to write each entry in the mediaList to a given
     * file in text or binary format. The text format is generated by simply
     * printing each media entry. The binary format is generated by writing the
     * whole mediaList ArrayList as a single object using an ObjectOutputStream.
     * 
     * @param filePath The path to the output file. If the file exists, then the
     *                 contents is overwritten.
     * @param isText   If this flag is true, then the output is written as text.
     *                 Otherwise the output is written in binary format.
     * 
     * @throws IOException This exception is exposed if any I/O error occurs.
     */
    public void writeMedia(String filePath, boolean isText) throws IOException {
        // Implement this method for both text and binary I/O
        if (isText) {
            PrintWriter pw = new PrintWriter(new File(filePath));

            for (Media m : mediaList) {
                pw.println(m);
            }
            pw.close();
        } else {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filePath))) {
                oos.writeObject(mediaList);
            }
        }
    }

    /**
     * <p>
     * Computes the total price of a set of media items to be purchased as a
     * bundle. Note that a totalPrice is computed by adding the price for each
     * media item. After that, the following formula is used to adjust the price
     * of the bundle:
     * </p>
     * <p>
     * finalPrice = totalPrice + (hdcpCount * 0.10) - (operaCount * 0.05)
     * </p>
     * where, hdcpCount is number of Video objects for which isHdcp returns true
     * and operaCount is number of Audio objects for which isOperatic is true
     * 
     * @param upcList The list of items whose total price is to be computed.
     * @return The total price of the list of items.
     */
    public float computeTotalPrice(ArrayList<String> upcList) {
        float totalPrice = 0;
        int hdcpCount = 0;
        int operaCount = 0;

        for (String s : upcList) {
            try {
                Media m = findMedia(s);
                totalPrice += m.getPrice();
                if (m instanceof Audio) {
                    if (((Audio) m).isOperatic()) {
                        operaCount++;
                    }
                } else {
                    if (((Video) m).isHdcp()) {
                        hdcpCount++;
                    }
                }
            } catch (InputMismatchException e) {
                totalPrice += 0;
            }
        }

        float finalPrice = (float) (totalPrice + (hdcpCount * 0.10)
                - (operaCount * 0.05));

        return finalPrice; // dummy return; remove it.
    }
}
