/*
 * @author  Raul Aguilar
 * @date    January 03, 2019
 */
package lemonadestand;
class Stand {
    private byte id;
    private float assets;
    private float price;
    private float income;
    private float revenue;
    private float expense;
    private float totalExpense;
    private float profit;
    private byte signs;
    private short totalSignsMade;
    private short cups;
    private short totalCupsMade;
    private short cupsSold;
    private short totalCupsSold;
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
     * @param bankrupt sets state of bankruptcy
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
        this.isBankrupt = other.isBankrupt;
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
     * Testing case is in Game.java
     * @param condition true is stand is bankrupt, else false
     */
    public void setBankrupt(boolean condition) {
        isBankrupt = condition;
    }

    /**
     * Sets price to price of lemonade by user
     * Used to keep track for financial reports
     * @param price price of lemonade
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Sets income
     * Used in financial reports
     * @param income Float income
     */
    public void setIncome(float income) {
        this.income = income;
    }

    public void setRevenue(float income) {
        this.revenue += income;
    }

    /**
     * Sets expense
     * Used in financial reports
     * @param expense Float expense
     */
    public void setExpense(float expense) {
        this.expense = expense;
    }

    public void setTotalExpense(float expense) {
        this.totalExpense += expense;
    }

    /**
     * Sets profit
     * Used in financial reports
     * @param profit Float profit
     */
    public void setProfit(float profit) {
        this.profit = profit;
    }

    public void setSigns(byte signs) {
        this.signs = signs;
    }

    /**
     * Used in endgame screen
     * @param signs signs made during day adds to total made
     */
    public void setTotalSignsMade(byte signs) {
        this.totalSignsMade += signs;
    }

    /**
     * Used in financial report
     * @param cups number of cups made for the day
     */
    public void setCups(short cups) {
        this.cups = cups;
    }

    /**
     * Used in the endgame screen
     * @param cups cups made for the day add to the total made
     */
    public void setTotalCupsMade(short cups) {
        this.totalCupsMade += cups;
    }

    /**
     * Sets number of cups sold
     * Used in financial reports
     * @param cups Short cups sold
     */
    public void setCupsSold(short cups) {
        this.cupsSold = cups;
    }

    /**
     * Used in the endgame screen
     * @param cupsSold adds to the total cups sold
     */
    public void setTotalCupsSold(short cupsSold) {
        this.totalCupsSold += cupsSold;
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
     * Accessor for boolean isBankrupt
     * @return true if stand is bankrupt, else false
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * Getter for number of cups sold
     * Used in financial reports
     * @return Short number of cups sold
     */
    public short getCupsSold() {
        return cupsSold;
    }

    /**
     * Used in the endgame screen
     * @return the total number of cups sold throughout campaign
     */
    public short getTotalCupsSold() {
        return totalCupsSold;
    }

    /**
     * Used in financial report
     * @return the price of lemonade
     */
    public float getPrice() {
        return price;
    }

    /**
     * Used in financial report
     * @return income made for the day
     */
    public float getIncome() {
        return income;
    }

    public float getRevenue() {
        return revenue;
    }

    /**
     * Used in financial report
     * @return number of cups made for the day
     */
    public short getCups() {
        return cups;
    }

    public short getTotalCupsMade() {
        return totalCupsMade;
    }

    /**
     * Used in financial report
     * @return number of signs made for the day
     */
    public byte getSigns() {
        return signs;
    }

    public short getTotalSignsMade() {
        return totalSignsMade;
    }

    /**
     * Used in financial report
     * @return the expense of the day
     */
    public float getExpense() {
        return expense;
    }

    public float getTotalExpense() {
        return totalExpense;
    }

    /**
     * Used in financial report
     * @return profit made for the day
     */
    public float getProfit() {
        return profit;
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
                + "\nAssets " + assets
                + "\nSigns " + signs
                + "\nCups " + cups
                + "\nCups Sold " + cupsSold
                + "\nPrice " + price
                + "\nIncome " + income
                + "\nExpense " + expense
                + "\nProfit " + profit;
    }
}
