package hw2;

import org.joda.time.*;

/**
 * This is the DPPoint class for the objects to store with DateTime value and price for that day
 * DPPoint stands for "Date-Price Point"
 * @author Hui Duan
 */

public class DPPoint {

    /* Creating objects*/
    private DateTime dateValue;
    private double priceValue;

    /**
     * Construct the DPPoint object that have date and price value in it
     * @param dateValue The value for the date
     * @param priceValue The value for the price
     */
    public DPPoint(DateTime dateValue, double priceValue)
    {
        this.dateValue = dateValue;
        this.priceValue = priceValue;
    }

    /**
     * getDateValue() method to get the date value
     * @return DateTime The date value
     */
    public DateTime getDateValue() {
        return dateValue;
    }

    /**
     * getDateValue() method to get the price value
     * @return double The price value
     */
    public double getPriceValue() {
        return priceValue;
    }

}
