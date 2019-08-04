package hw2;

import java.util.List;

/**
 * This is the CallOptionPayout class implementing Payout interface
 * This class is implementing the European Options payout function by compare 0 with the max value of
 * the last price of the brownianStorckPath simulation subtract the strikePrice.
 * @author Hui Duan
 * @see Payout
 */
public class CallOptionPayout implements Payout {
    /*initialize the strikePrice*/
    private double strikePrice;

    /**
     * Construct a CallOptionPayout method that will return the payout of the simulation
     * @param strikePrice The posting price value of expiration date
     */
    public CallOptionPayout(double strikePrice)
    {
        this.strikePrice = strikePrice;
    }

    /**
     * getStrikePrice() method will get the strikePrice value
     * @return double The strikePrice value
     */
    public double getStrikePrice() {
        return strikePrice;
    }

    /**
     * getPayout() method will take a BrownianStorckPath and get the last price value to subtract strike price,
     * then return the max between the value and 0
     * @param path The random brownianStorckPath to calculate the payout
     * @return double The amount of the europeanPayout
     */
    public double getPayout(StockPath path)
    {
        List<DPPoint> priceList;
        priceList = path.getPrices();

        double europeanPayout;
        europeanPayout = Math.max(priceList.get(priceList.size() -1 ).getPriceValue() - strikePrice, 0);

        priceList.clear();
        return europeanPayout;
    }


}
