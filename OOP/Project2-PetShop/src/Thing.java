

public abstract class Thing {
    /**
     * An empty constructor.
     */
    public Thing() {
    }

    /**
     * A Placeholder for the getKind methods in other classes.
     *
     * @return null as there is no kind variable to access
     */
    public String getKind() {
        return null;
    }

    /**
     * A Placeholder for the isAquatic methods in other classes.
     *
     * @return false as nothing is actually being checked
     */
    public boolean isAquatic() {
        return false;
    }

    /**
     * A Placeholder for the getPrice methods in other classes.
     */
    public abstract float getPrice();
}
