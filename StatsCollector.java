package hw2;

import java.util.ArrayList;

/**
 * This is the StatsCollector class
 * This class will keep track of stats of average and standard deviation
 * @author Hui Duan
 * @see StockPath
 */
public class StatsCollector {

    /*initialize objects*/
    private ArrayList<Double> arrayList;

    private double mean = 0.0;
    private double stdDeviation = 0.0;
    private double meanSquared = 0.0;

    /**
     * Constuct a StatsCollector to collect the information about average and
     * standard deviation
     */
    public StatsCollector()
    {
        this.arrayList = new ArrayList<>();
    }

    /**
     * calculateStdDiv() method will calculate the
     * @param x The payout value
     */
    public void calculateStdDiv(double x)
    {

        int N = arrayList.size() + 1 ;
        arrayList.add(x);
        mean = (N-1.0)/N * mean + x/N;
//        System.out.println(x);
        meanSquared = (N-1.0)/N * meanSquared + (x * x)/N;
        stdDeviation = Math.sqrt(meanSquared - (mean * mean));
    }

    /**
     * getStdDeviation() method will return the value of standard deviation
     * @return double The value of standard deviation
     */
    public double getStdDeviation() {
        return stdDeviation;
    }

    /**
     * getMean() method will return the value of average
     * @return double The value of average
     */
    public double getMean() {
        return mean;
    }
}
