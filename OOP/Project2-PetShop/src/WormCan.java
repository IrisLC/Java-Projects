

public class WormCan extends Food {
    /**
     * A Constructor that sends the information entered to the Food constructor
     * to create the object.
     *
     * @param price  the cost of the food
     * @param weight the weight of the food
     */
    public WormCan(float price, float weight) {
        super(price, weight);
    }

    /**
     * Returns the kind of food.
     *
     * @return the kind of food
     */
    @Override
    public String getKind() {
        return "WormCan";
    }

    /**
     * Converts all variable data into a string.
     *
     * @return the full string of data
     */
    @Override
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "WormCan", price, weight);
    }

    /**
     * Returns if the food is aquatic.
     *
     * @return true, as worms are used for aquatic animals
     */
    @Override
    public boolean isAquatic() {
        return true;
    }
}
