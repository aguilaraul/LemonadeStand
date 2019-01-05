/*
 * @author  Raul Aguilar
 * @date    January 04, 2019
 */
class Stand {
    private byte id;
    private float assets;
    private boolean isBankrupt;
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

// Setters
    /**
     * Sets the lemonade stand number
     * @param i lemonade stand number
     */
    public void setId(byte i) {
        this.id = i;
    }

    /**
     * Sets the assets for the lemonade stand
     * @param a available funds
     */
    public void setAssets(float a) {
        this.assets = a;
    }

    /**
     * Set the condition of isBankrupt
     * Testing case is in Game.java
     * @param condition true is stand is bankrupt, else false
     */
    public void setBankrupt(boolean condition) {
        this.isBankrupt = condition;
    }

    public void setAll(float price, float expense, float income, float profit, short cups, short cupsSold, byte signs) {
	    this.price = price;
	    this.expense = expense;
	    this.income = income;
	    this.profit = profit;
	    this.cups = cups;
	    this.cupsSold = cupsSold;
	    this.signs = signs;
	    setTotalSignsMade(signs);
	    setTotalCupsMade(cups);
	    setTotalCupsSold(cupsSold);
	    setTotalExpense(expense);
	    setRevenue(income);
    }

    /**
     * Price of lemonade set by stand
     * Used in financial reports
     * @param price price of lemonade
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Income of stand for the day
     * Used in financial reports
     * @param income income of the stand
     */
    public void setIncome(float income) {
        this.income = income;
    }

    /**
     * Add income of the day to the total revenue
     * Used in the endgame screen
     * @param income adds income from day to total revenue
     */
    public void setRevenue(float income) {
        this.revenue += income;
    }

    /**
     * Sets expense of the day of the stand
     * Used in financial reports
     * @param expense expense of the stand
     */
    public void setExpense(float expense) {
        this.expense = expense;
    }

    /**
     * Adds expense of the day to the total expense
     * Used in the endgame screen
     * @param expense adds to the total expense of the stand
     */
    public void setTotalExpense(float expense) {
        this.totalExpense += expense;
    }

    /**
     * Sets profit
     * Used in financial reports
     * @param profit profit of the stand for the day
     */
    public void setProfit(float profit) {
        this.profit = profit;
    }

    /**
    * Sets to the number of signs made by the stand for the day
    * Used in financial reports
    * @param signs byte of signs made during day
    */
    public void setSigns(byte signs) {
        this.signs = signs;
    }

    /**
     * Adds signs made in the day to total signs made by stand
     * Used in endgame screen
     * @param signs signs made during day adds to total made
     */
    public void setTotalSignsMade(byte signs) {
        this.totalSignsMade += signs;
    }

    /**
     * Cups of lemonade made by the stand
     * Used in financial report
     * @param cups number of cups made for the day
     */
    public void setCups(short cups) {
        this.cups = cups;
    }

    /**
     * Adds the cups made in the day to total cups made by stand
     * Used in the endgame screen
     * @param cups cups made for the day add to the total made
     */
    public void setTotalCupsMade(short cups) {
        this.totalCupsMade += cups;
    }

    /**
     * Sets number of cups sold by the stand in the day
     * Used in financial reports
     * @param cups Short cups sold
     */
    public void setCupsSold(short cups) {
        this.cupsSold = cups;
    }

    /**
     * Adds cups sold in the day to total cups sold
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

    /**
     * Used in the endgame screen
     * @return total revenue made by stand
     */
    public float getRevenue() {
        return revenue;
    }

   /**
     * Used in financial report
     * @return the expense of the day
     */
    public float getExpense() {
        return expense;
    }

    /**
     * Used in the endgame screen
     * @return total expense 
     */
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
     * Used in financial report
     * @return number of signs made for the day
     */
    public byte getSigns() {
        return signs;
    }

    /**
     * Get the total number of signs made by the stand
     * Used in the endgame screen
     * @return total number of signs made
     */
    public short getTotalSignsMade() {
        return totalSignsMade;
    }

    /**
     * Gets the number of cups made by the stand during the day
     * Used in financial report
     * @return number of cups made for the day
     */
    public short getCups() {
        return cups;
    }

    /**
     * Gets the total number of cups made by the stand
     * Used in the endgame screen
     * @return total numbe of cups made
     */
    public short getTotalCupsMade() {
        return totalCupsMade;
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
     * Gets the total number of cups sold by the stand
     * Used in the endgame screen
     * @return the total number of cups sold throughout campaign
     */
    public short getTotalCupsSold() {
        return totalCupsSold;
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
