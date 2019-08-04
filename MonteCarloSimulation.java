package hw2;

/**
 * This is the MonteCarloSimulation class
 * This is the class of simulation manager and uses 3 inputs to run the simulation and decide when to stop
 * based on our desired tolerance
 * @author Hui Duan
 */
public class MonteCarloSimulation {

    /**
     * The function to perform MonteCarloSimulation
     * @param path The Path object to use in the simulation
     * @param payOut The Payout object to use in the simulation
     * @param statsCollector The StatsCollector object to use in the simulation
     * @param toleranceProbability The tolerance for Probability use in the simulation
     * @param toleranePriceDiff The tolerance for Price Difference to use in the simulation
     * @return double The value of option in expiration date
     */
    public double MCSimulation(StockPath path,Payout payOut, StatsCollector statsCollector,double toleranceProbability, double toleranePriceDiff)
    {
        double counter = 0.0;
        double avgPercent;
        MonteCarloSimulation mcs = new MonteCarloSimulation();
        double bound = mcs.NormalCDFinverse(toleranceProbability);
        for (int i = 1; i< 5000000; i++)
        {
            statsCollector.calculateStdDiv(payOut.getPayout(path));
            if (bound * statsCollector.getStdDeviation()/ Math.sqrt(i) < toleranePriceDiff && i > 1) {
                counter++;
            }
            avgPercent = counter/i;
            //Converge condition
            if (avgPercent > 0.96 && i > 20)
            {
                break;
            }
        }
        return statsCollector.getMean();
    }


    /**
     * calculateXp() method is to calculate Xp in the Formula 26.2.23 from Abramowitz and Stegun
     * @param t The value of t in the formula
     * @return double The Xp value we calculate
     */
    public double calculateXp(double t)
    {
        double c[] = {2.515517, 0.802853, 0.010328};
        double d[] = {1.432788, 0.189269, 0.001308};
        return t - ((c[0] + (c[1]+c[2]*t)*t) / ((d[0] + (d[1]+d[2]*t)*t)*t +1.0));
    }

    /**
     * NormalCDFinverse() method is to calculate the inverse of NormalCDF
     * @param p The value of the probability
     * @return double The value of the result
     */
    public double NormalCDFinverse(double p)
    {
        if (p<=0.0 || p>=1.0)
        {
            System.out.println(" Invalid value for probability, must less than 1 and larger than 0 ");
            return 0.0;
        }
        if ( p < 0.5)
        {
            double y = -calculateXp(Math.sqrt(-2.0*Math.log(p)));
            return y;
        }
        else
        {
            double y = calculateXp(Math.sqrt(-2.0*Math.log(1-p)));
            return y;
        }
    }

    /**
     * This is the main method to test the simulation with two different options(One with European payout and one with
     * Asian Payout)
     * @param args
     */
    public static void main (String[] args)
    {
        double value;
        double value2;
        double optionPrice;
        double optionPrice2;
        double priceValue = 152.35;
        double rateValue = 0.0001;
        double sigmaValue = 0.01;
        double strikePrice = 165;
        int numberOfDays = 252;
        double toleranceProb= 0.96;
        double tolerancePric= 0.1;

        System.out.println("=================== CallOptionPayout ====================");
        MonteCarloSimulation mc_Simulation = new MonteCarloSimulation();
        GuassianRandomVeriableGenerator grvGen = new GuassianRandomVeriableGenerator(numberOfDays);
        BrownianStockPathGenerator brownianStockPathGenerator = new BrownianStockPathGenerator(grvGen,priceValue,rateValue,sigmaValue,numberOfDays);
        CallOptionPayout cop = new CallOptionPayout(strikePrice);
        StatsCollector statCollec = new StatsCollector();
        value = mc_Simulation.MCSimulation(brownianStockPathGenerator,cop,statCollec,toleranceProb,tolerancePric);
        optionPrice = value * Math.exp(-rateValue*numberOfDays);
        System.out.println("The value of a call option after 252 days is :"+value);
        System.out.println("The option should be priced :" + optionPrice);

        double priceValue2 = 152.35;
        double rateValue2 = 0.0001;
        double sigmaValue2 = 0.01;
        double strikePrice2 = 164;
        int numberOfDays2 = 252;
        double toleranceProb2= 0.96;
        double tolerancePric2= 0.1;

        System.out.println("=================== AsianCallOptionPayout ====================");
        MonteCarloSimulation mc_Simulation2 = new MonteCarloSimulation();
        GuassianRandomVeriableGenerator grvGen2 = new GuassianRandomVeriableGenerator(numberOfDays);
        BrownianStockPathGenerator brownianStockPathGenerator2 = new BrownianStockPathGenerator(grvGen2,priceValue2,rateValue2,sigmaValue2,numberOfDays2);
        AsianCallPayout acp = new AsianCallPayout(strikePrice2);
        StatsCollector statCollec2 = new StatsCollector();
        value2 = mc_Simulation2.MCSimulation(brownianStockPathGenerator2,acp,statCollec2,toleranceProb2,tolerancePric2);
        optionPrice2 = value2 * Math.exp(-rateValue2*numberOfDays2);
        System.out.println("The value of a call option after 252 days is:"+value2);
        System.out.println("The option should be priced:" + optionPrice2);
    }

}
