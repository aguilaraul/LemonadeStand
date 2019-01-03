/*
 * @author  Raul Aguilar
 * @date    January 02, 2019
 */
package lemonadestand;
class Stand {
    private byte id;
    private float assets;
    private boolean isBankrupt;

    /**
     * Default constructor with no arguments
     */
    public Stand() {
        this.id = 0;
        this.assets = 2.00f;
        this.isBankrupt = false;
    }

    /**
     * Constructor to set id only
     * @param id sets lemonade stand number
     */
    public Stand(byte id) {
        this.id = id;
        this.assets = 2.00f;
        this.isBankrupt = false;
    }

    /**
     * Full constructor
     * @param id sets lemonade stand number
     * @param assets sets assets for lemonade stand
     */
    public Stand(byte id, float assets, boolean bankrupt) {
        this.id = id;
        this.assets =  assets;
        this.isBankrupt = bankrupt;
    }

    /**
     * Deep copy constructor
     * @param other used to store deep copy
     */
    public Stand(Stand other) {
        this.id = other.id;
        this.assets = other.assets;
    }

    /**
     * Sets the lemonade stand number
     * @param i lemonade stand number
     */
    public void setId(byte i) {
        id = i;
    }

    /**
     * Sets the assets for the lemonade stand
     * @param a available funds
     */
    public void setAssets(float a) {
        assets = a;
    }

    /**
     * Set the condition of isBankrupt
     * @param condition true is stand is bankrupt, else false
     */
    public void setBankrupt(boolean condition) {
        isBankrupt = condition;
    }

    /**
     * Accessor for lemonade stand number
     * @return lemonade stand number integer value
     */
    public byte getId() {
        return id;
    }

    /**
     * Accessor for lemonade stand assets
     * @return assets available double value
     */
    public float getAssets() {
        return assets;
    }

    /**
     * Acessor for boolean isBankrupt
     * @return true if stand is bankrupt, else false
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
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
