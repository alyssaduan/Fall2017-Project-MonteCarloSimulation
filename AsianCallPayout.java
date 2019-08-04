package hw2;

import java.util.List;

/**
 * This is the AsianCallPayout class implementing Payout interface
 * This class is implementing the Asian Call Options payout function by compare 0 with the average value of
 * the price from the brownianStorckPath simulation subtract the strikePrice.
 * @author Hui Duan
 * @see Payout
 */
public class AsianCallPayout implements Payout {
    /*initialize objects*/
    private double strikePrice;

    /**
     * getStrikePrice() method will get the value of Strike Price
     * @return double Strike Price value
     */
    public double getStrikePrice() {
        return strikePrice;
    }

    /**
     * Construct a AsianCallPayout method that will return the asian call option payout of the simulation
     * @param strikePrice The posting price value of expiration date to use to calculate the payout
     */
    public AsianCallPayout(double strikePrice)
    {
        this.strikePrice = strikePrice;
    }

    /**
     *
     * @param path
     * @return
     */
    public double getPayout(StockPath path)
    {
        List<DPPoint> priceList = path.getPrices();
        double dailyPriceSum = 0.0;
        double avgPrice;
        double result;
        for (DPPoint priceOfEachDay : priceList)
        {
            dailyPriceSum += priceOfEachDay.getPriceValue();
        }
//        System.out.println(" dailyPriceSum : "+ dailyPriceSum);
        avgPrice = dailyPriceSum / priceList.size();
//        System.out.println(" avgPrice : "+ avgPrice);
        result = Math.max(avgPrice - strikePrice,0);
//        System.out.println(" result : "+ result);
        return result;
    }
}
