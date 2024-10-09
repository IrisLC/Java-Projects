

public class Pet extends Thing {
    /**
     * The kind of pet the object is.
     */
    protected String kind;
    /**
     * The price of the pet.
     */
    protected float price;
    /**
     * the amount of food needed per day.
     */
    protected float foodPerDay;

    /**
     * A Constructor that creates a basic pet object while initializing
     * the three main variables.
     *
     * @param name       the kind of pet
     * @param price      the cost of the pet
     * @param foodPerDay the food needed per day
     */
    public Pet(String name, float price, float foodPerDay) {
        this.kind = name;
        this.price = price;
        this.foodPerDay = foodPerDay;
    }

    /**
     * returns the price of the pet.
     *
     * @return the price variable
     */
    @Override
    public float getPrice() {
        return price;
    }

    /**
     * returns the amount of food needed per day for the pet.
     *
     * @return the foodPerDay variable
     */
    public float getFoodPerDay() {
        return foodPerDay;
    }

    /**
     * Checks this object with another object to determine if they are of the
     * same class and same kind.
     *
     * @param o the object that is being checked
     * @return whether or not the two objects are equal
     */
    public boolean equals(Object o) {
        if (o == null || (o.getClass() != this.getClass())) {
            return false;
        }

        Pet other = (Pet) o;

        return (this.kind.equals(other.kind));
    }
}
