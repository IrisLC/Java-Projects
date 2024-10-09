/**
 * Iris Currie
 * Section: K
 * Fall 2023
 * This program creates ArrayLists from files 
 * of Shipping objects and then reads and sorts them
 * in various ways
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project4 {
    
    private static boolean done = false;
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        ArrayList<Shipping> list = new ArrayList<Shipping>();
        ArrayList<Shipping> listCopy = new ArrayList<Shipping>();
                
        do {
            //create the list of options, get user input then enter choices
            menu();
            choices(in.nextInt(), in, list, listCopy); 
            if (!done) { 
                System.out.println();
            }       
        } while (!done);
        
        System.out.print("End!");
    }
    
    /**
    * Prints out the menu of choices that the user can make.
    *
    */
    public static void menu() {
        System.out.println("1. Load from a file");
        System.out.println("2. Print from the loaded list");
        System.out.println("3. Sort the list based on shipment IDs");
        System.out.println("4. Sort the list based on the tracking numbers");
        System.out.println("5. Print the sorted list");
        System.out.println("6. Exit");
        System.out.println("Enter a number[1-6]: ");
    }
    
    /**
    * Handles the choice the user made and calls the necessary methods.
    *
    * @param choice  the user's input
    * @param in  the scanner being used to get a user's input
    * @param list  the main list that will be used for holding objects
    * @param listCopy  the copy of list used for sorting
    */
    public static void choices(int choice, Scanner in, 
        ArrayList<Shipping> list, ArrayList<Shipping> listCopy) {
        
        if (choice == 1) {
            //get filename and import it
            System.out.println("Enter the name of the file:");
            fileLoader(in.next(), list);
            System.out.println("Loading from the file is done!");
            //make a copy for sorting purposes
            copy(list, listCopy);
        } else if (choice == 2) {
            //check if a list has been loaded
            if (list.isEmpty()) {
                System.out.print("No data has been loaded yet!");
            } else {
                //print out list
                display(list, in);
            }
        } else if (choice == 3) {
            //shipment ID sort
            if (list.isEmpty()) {
                System.out.print("No data has been loaded yet!");
            } else {
                //print out list
                sort1(listCopy);
                System.out.println("Sorting is done!");
            }
        } else if (choice == 4) {
            //Tracking Number sort
            if (list.isEmpty()) {
                System.out.print("No data has been loaded yet!");
            } else {
                //print out list
                sort2(listCopy);
                System.out.println("Sorting is done!");
            }            
        } else if (choice == 5) {
            if (list.equals(listCopy)) {
                System.out.print("No data has been loaded yet!");
            } else {
                //print out list
                display(listCopy, in);
            }
        } else if (choice == 6) {
            done = true;
        }
    }
    
    /**
    * takes user input and attempts to attatch a file to the scanner,
    * then will read the contents of the file as Shipping objects and
    * add those objects to an ArrayList.
    *
    * @param fileName  the file that the user wants to be read
    * @param list  the ArrayList that the objects will be added to
    */
    
    public static void fileLoader(String fileName, ArrayList<Shipping> list) {
        Scanner sc = null;
        
        try {
            //assign the scanner
            sc = new Scanner(new File(fileName));
            
            //while the file is not done
            while (sc.hasNext()) {
                //create a new shipping object
                Shipping entry = new Shipping(
                    sc.nextInt(), sc.nextInt(), sc.next(), sc.next());
                //assign the object into the ArrayList
                list.add(entry);
            } 
        } catch (FileNotFoundException e) {
            System.out.println("Error, the file does not exist");
            System.out.println(e);
        } finally {
            try {
                sc.close();
            } catch (Exception f) {
                System.out.println(f);
            }
        }
    }
    
    
    /**
    * prints out the contents of an ArrayList in sets of 10.
    *
    * @param list  The ArrayList being displayed
    * @param in  The Scanner for user input
    */
    public static void display(ArrayList<Shipping> list, Scanner in) {
        int counter = 0;
        int end = 10;
        boolean finish = false;
        System.out.println("**** Printing the list ****");
        //while the user wants to continue printing
        do {
            //run the loop until the list is either empty 
            //or has gone through 10 loops
            for (int i = 0 + counter; i < list.size() && i < end; i++) {
                //get the object from the list
                Shipping entry = list.get(i);
                //put it to a string and print
                System.out.println(entry.toString());
                counter++;
            }
            //check for continue
            System.out.println("Enter something to continue/enter s to stop");
            String response = in.next();
            end += 10;
            if (response.equals("s") || counter == list.size()) {
                finish = true;
            }
        } while (!finish);
    }
    
    /**
    * deepcopies one array list to another.
    *
    * @param start  the list being copied
    * @param copy  the list being copied to
    */
    
    public static void copy(ArrayList<Shipping> start, ArrayList<Shipping> copy) {
        //copy over the list
        for (int i = 0; i < start.size(); i++) {
            copy.add(start.get(i));
        }
    }
    
    /**
    * sorts an ArrayList of shipping objects based on shipping ID's.
    *
    * @param list  the ArrayList being sorted
    */
    
    public static void sort1(ArrayList<Shipping> list) {
        //bubble sort
        //check if list has entries and if it is bigger than 1 
        if (list.isEmpty() || list.size() < 2) {
            return;
        }

        for (int pass = 0; pass < list.size() - 1; pass++) {
            for (int i = 0; i < (list.size() - pass - 1); i++) {
                //make objects out of the two areas being checked
                Shipping item1 = list.get(i);
                Shipping item2 = list.get(i + 1);
                //if the id of one is less than the other switch them
                if (item1.getShipmentID() > item2.getShipmentID()) {
                    Shipping temp = item1;
                    list.set(i, item2);
                    list.set(i + 1, temp);
                }
            }
        }
    }
    
    
    /**
    * sorts an ArrayList of shipping objects based on tracking numbers.
    *
    * @param list  the ArrayList being sorted
    */
    
    public static void sort2(ArrayList<Shipping> list) {
        //bubble sort
        //check if list has entries and if it is bigger than 1 
        if (list.isEmpty() || list.size() < 2) {
            return;
        }

        for (int pass = 0; pass < list.size() - 1; pass++) {
            for (int i = 0; i < (list.size() - pass - 1); i++) {
                //Get the trackingnumbers
                String trackNum1 = list.get(i).getTrackingNumber();
                String trackNum2 = list.get(i + 1).getTrackingNumber();
                //if the number of one is less than the other switch them
                if (trackNum1.compareTo(trackNum2) > 0) {
                    Shipping temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }

    }

}
