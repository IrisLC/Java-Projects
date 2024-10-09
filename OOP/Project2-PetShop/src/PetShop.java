import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple pet store that has pets and food things.
 *
 */
public class PetShop {
    /**
     * The items available for sale in this pet shop. The items are added to
     * this list via the addItemsFromFile method.
     */
    private ArrayList<Thing> things;

    /**
     * This is an intermediate summary string that has been used to generate the
     * full summary format below. Don't use this one. Instead, use the
     * SUMMARY_FORMAT string below.
     */
    private static final String SUMMARY_SUB_FORMAT = 
            "    Number of pets      : %d%n"
            + "    Total price pets    : $%.2f%n"
            + "    Number of food items: %d%n"
            + "    Total price of food : $%.2f%n";

    /**
     * Format string to print summary of pets and food items in the pet store.
     */
    private static final String SUMMARY_FORMAT = 
            "Summary of items in Pet Shop%n"
            + "Aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT
            + "Non-aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT;

    /**
     * Format string to print food status for the pet store.
     */
    private static final String FOOD_STATUS = "Pet Shop food status:%n"
            + "    Daily aquatic food needed      : %.2f lb%n"
            + "    Daily non-aquatic food needed  : %.2f lb%n"
            + "    Aquatic food stock in store    : %.2f lb%n"
            + "    Non-aquatic food stock in store: %.2f lb%n";

    /**
     * Creates an empty shop without any items.
     */
    public PetShop() {
        things = new ArrayList<>();
    }

    /**
     * Returns the number of food objects in the list of things in this pet
     * store.
     * 
     * @return The number of food things currently in the list of things in this
     *         pet store.
     */
    public int getFoodCount() {
        int counter = 0;
        for (Thing i : things) {
            if (i instanceof Food) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Returns the number of pet objects in the list of things in this pet
     * store.
     * 
     * @return The number of pets currently in the list of things in this pet
     *         store.
     */
    public int getPetCount() {
        int counter = 0;
        for (Thing i : things) {
            if (i instanceof Pet) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Adds items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. The data in the lines are
     * with: 3-columns for Food: FoodName Price Weight 4-columns for Pet :
     * PetNamme PetKind Price FoodPerDay
     * 
     * @param fileName The text file from where Things are to be added to the
     *                 list of items for sale in the pet store.
     */
    public void addItemsFromFile(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] list = str.split("\t");

            if (list.length == 3) {
                addFood(list[0], Float.parseFloat(list[1]),
                        Float.parseFloat(list[2]));
            } else if (list.length == 4) {
                addPet(list[0], list[1], Float.parseFloat(list[2]),
                        Float.parseFloat(list[3]));
            }
        }
    }

    /**
     * Creates a Food object based on the name provided from another method and
     * places it into an ArrayList.
     * 
     * @param name   the type of Food being made
     * @param price  the price of the Food
     * @param weight the weight of the food
     */
    public void addFood(String name, float price, float weight) {
        if (name.equals("WormCan")) {
            things.add(new WormCan(price, weight));
        } else {
            things.add(new ChowBag(price, weight));
        }
    }

    /**
     * Creates a Pet object based on the name provided from another method and
     * places it into an ArrayList.
     * 
     * @param name       the type of pet being made
     * @param kind       the kind of pet type
     * @param price      the price of the animal
     * @param FoodPerDay the food needed per day for the animal to eat
     */
    public void addPet(String name, String kind, float price,
            float foodPerDay) {
        if (name.equals("Cat")) {
            things.add(new Cat(kind, price, foodPerDay));
        } else if (name.equals("Dog")) {
            things.add(new Dog(kind, price, foodPerDay));
        } else if (name.equals("Fish")) {
            things.add(new Fish(kind, price, foodPerDay));
        } else {
            things.add(new Octopus(kind, price, foodPerDay));
        }
    }

    /**
     * Interface method to print a summary of the items in the pet store. The
     * summary is computed and printed using the supplied SUMMARY_FORMAT string.
     * 
     * @see SUMMARY_FORMAT
     */
    public void printSummary() {
        int aqPets = 0, aqFood = 0, naqPets = 0, naqFood = 0;
        float aqPFood = 0, aqPPets = 0, naqPFood = 0, naqPPets = 0;
        for (Thing i : things) {
            if (i instanceof Pet) {
                if (i.isAquatic()) {
                    aqPets++;
                    aqPPets += i.getPrice();
                } else {
                    naqPets++;
                    naqPPets += i.getPrice();
                }
            } else {
                if (i.isAquatic()) {
                    aqFood++;
                    aqPFood += i.getPrice();
                } else {
                    naqFood++;
                    naqPFood += i.getPrice();
                }
            }
        }
        System.out.printf(SUMMARY_FORMAT, aqPets, aqPPets, aqFood, aqPFood,
                naqPets, naqPPets, naqFood, naqPFood);
    }

    /**
     * A simple method that prints all of the things in the store.
     */
    public void printAllThings() {
        System.out.println("List of all items:");
        for (Thing i : things) {
            System.out.println(i.toString());
        }
    }

    /**
     * Computes and prints the amount of aquatic and non-aquatic food needed to
     * feed all of the pets in the store along with the amount of food currently
     * available. The food needed by pets is computed by adding the daily food
     * needs of all the pets. The food available is computed by adding the
     * weight of all the food things.
     * 
     * @see FOOD_STATUS
     */
    public void reportFoodStatus() {
        float aqNeed = 0, aqReq = 0, naNeed = 0, naReq = 0;
        for (Thing i: things) {
            if (i instanceof Pet) {
                if (i.isAquatic()) {
                    aqNeed += ((Pet) i).getFoodPerDay();
                } else {
                    naNeed += ((Pet) i).getFoodPerDay();
                }
            } else {
                if (i.isAquatic()) {
                    aqReq += ((Food) i).getWeight();
                } else {
                    naReq += ((Food) i).getWeight();
                }
            }
        }
        
        System.out.printf(FOOD_STATUS, aqNeed, naNeed, aqReq, naReq);
    }
}
