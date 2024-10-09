

public class Fish extends Pet {
    /**
     * A Constructor that sends the information entered to the Pet constructor
     * to create the object.
     *
     * @param name       the kind of pet
     * @param price      the cost of the pet
     * @param foodPerDay the food needed per day
     */
    public Fish(String name, float price, float foodPerDay) {
        super(name, price, foodPerDay);
    }

    /**
     * Returns the name of the Class followed by the kind of pet.
     *
     * @return the String of the name of animal then kind
     */
    @Override
    public String getKind() {
        return "Fish: " + kind;
    }

    /**
     * Converts all variable data into a string.
     *
     * @return the full string of data
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Fish", kind, price,
                foodPerDay);
    }

    /**
     * Returns if the animal is aquatic.
     *
     * @return true, as a fish is aquatic
     */
    @Override
    public boolean isAquatic() {
        return true;
    }
}
