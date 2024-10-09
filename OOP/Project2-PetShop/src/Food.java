

public class Food extends Thing {

    /**
     * The price for the food.
     */
    protected float price;
    /**
     * The weight of the food.
     */
    protected float weight;

    /**
     * A Constructor that creates a basic food object while initializing the two
     * main variables.
     *
     * @param price  the cost of the food
     * @param weight the weight of the food
     */
    public Food(float price, float weight) {
        this.price = price;
        this.weight = weight;
    }

    /**
     * returns the price of the food.
     *
     * @return the price variable
     */
    public float getPrice() {
        return price;
    }

    /**
     * returns the weight of the food.
     *
     * @return the weight variable
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Checks this object with another object to determine if they are of the
     * same class, same price, and same weight.
     *
     * @param o the object that is being checked
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Food other = (Food) o;

        return ((this.price == other.price) && (this.weight == other.weight));
    }
}
