/**
 * @author  Raul Aguilar
 * @date    2018-10-16
 */
package lemonadestand;

class Stand {
    private int id;
    private double assets;

    /**
     * Default constructor with no arguments
     */
    public Stand() {
        this.id = 0;
        this.assets = 2.00;
    }

    /**
     * Constructor to set id only
     * @param id
     *  sets lemonade stand number
     */
    public Stand(int id) {
        this.id = id;
        this.assets = 2.00;
    }

    /**
     * Full constructor
     * @param id
     *  sets lemonade stand number
     * @param assets
     *  sets assets for lemonade stand
     */
    public Stand(int id, double assets) {
        this.id = id;
        this.assets =  assets;
    }

    /**
     * Deep copy constructor
     * @param other
     *  used to store deep copy
     */
    public Stand(Stand other) {
        this.id = other.id;
        this.assets = other.assets;
    }

    /**
     * Sets the lemonade stand number
     * @param i
     *  lemonade stand number
     */
    public void setId(int i) {
        id = i;
    }

    /**
     * Sets the assets for the lemonade stand
     * @param a
     *  available funds
     */
    public void setAssets(double a) {
        assets = a;
    }

    /**
     * Accessor for lemonade stand number
     * @return lemonade stand number integer value
     */
    public int getId() {
        return id;
    }

    /**
     * Accessor for lemonade stand assets
     * @return assets available double value
     */
    public double getAssets() {
        return assets;
    }

    /**
     * Equals method checks all instance variable are equal
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Stand other = (Stand) obj;

        return (this.id != other.id || this.assets != other.assets);
    }

    /**
     * toString representing objects value
     * @return formatted string of lemonade stand and its assets
     */
    @Override
    public String toString(){
        return "Lemonade Stand " + id
                + "\nAssets " + assets;
    }
}