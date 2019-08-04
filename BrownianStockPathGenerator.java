package hw2;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.*;

/**
 * This is the BrownianStockPathGenerator class implementing StockPath interface
 * This class will generate a list of DDP objects and we treat them as the simulation of the future stock path.
 * @author Hui Duan
 * @see StockPath
 */

public class BrownianStockPathGenerator implements StockPath {

    private final double price;
    private final double rate;
    private final double sigma;
    private final int numberOfdays;
    private RandomVariableGenerator generator;


    /**
     * Construct a BrownianStockPathGenerator using 4 parameters and generate geometric brownian motion stock prices path
     * @param price The price value for the initial stock price
     * @param rate The initial rate value
     * @param sigma The initial volatility value
     * @param numberOfdays Number of days to generate
     */
    public BrownianStockPathGenerator(RandomVariableGenerator generator, double price, double rate, double sigma, int numberOfdays)
    {
        this.price = price;
        this.rate = rate;
        this.sigma = sigma;
        this.numberOfdays = numberOfdays;
        this.generator = generator;
    }

    /**
     * getPrices() method will take the vector from AntitheticDecoratorGenerator, and use the formula to calculate the
     * new possible price for each day. Then we store them in new DPPoint objects, and add the object to the list
     * @return List<DPPoint> The list of all possible price for each day with DateTime information (Simulation stock Path)
     */
    public List<DPPoint> getPrices()
    {
        List<DPPoint> listOfPrices = new ArrayList<>();
        double tempPrice = price;
        double tempSigma = sigma;

        AntitheticDecoratorGenerator antithDecoGen = new AntitheticDecoratorGenerator(generator);

        double[] normalDisVector = antithDecoGen.getVector();
        DateTime dateValue = new DateTime();

        for (double normalDis : normalDisVector)
        {
            dateValue = dateValue.plusDays(1);
            tempPrice = tempPrice * Math.exp((rate - (tempSigma * tempSigma)/2)+ tempSigma * normalDis);
            listOfPrices.add(new DPPoint(dateValue,tempPrice));
        }
        return listOfPrices;
    }

}
