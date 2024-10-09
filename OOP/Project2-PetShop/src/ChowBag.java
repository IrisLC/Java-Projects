

public class ChowBag extends Food {
    /**
     * A Constructor that sends the information entered to the Food constructor
     * to create the object.
     *
     * @param price  the cost of the food
     * @param weight the weight of the food
     */
    public ChowBag(float price, float weight) {
        super(price, weight);
    }

    /**
     * Returns the kind of food.
     *
     * @return the kind of food
     */
    @Override
    public String getKind() {
        return "ChowBag";
    }

    /**
     * Converts all variable data into a string.
     *
     * @return the full string of data
     */
    @Override
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "ChowBag", price, weight);
    }

    /**
     * Returns if the food is aquatic.
     *
     * @return false, as the chow bag is used for non aquatic animals
     */
    @Override
    public boolean isAquatic() {
        return false;
    }
}
