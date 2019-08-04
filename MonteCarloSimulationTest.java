package hw2;

import org.joda.time.DateTime;

import org.junit.*;

import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This is the JUnit test for MonteCarloSimulation class using Mockito
 * @author Hui Duan
 */

public class MonteCarloSimulationTest {

    private static double strikePriceValue = 125;

    /**
     * We are creating two "Dummy Paths" for testing
     * tempPath1 contains a list of DPPoints with interestRate of 0.1 for everyday
     * tempPath2 contains a list of DPPoints with interestRate of 0.001 for everyday
     */
    private List<DPPoint> tempPath1;
    private  List<DPPoint> tempPath2;

    /**
     * Generate all needing testing paths
     */
    @Before
    public void generateTestPath(){
       tempPath1 = new ArrayList<>();
       tempPath2 = new ArrayList<>();

        int numOfdays = 10;

        double tempPrice1 = (double) 100;
        double tempPrice2;
        double interestRate = 0.1;
        double interestRate2 = 0.001;

        DateTime tempTime = new DateTime();

        //Using for loop to create two dummy Paths
        for(int i=0; i<numOfdays;i++) {
            tempTime = tempTime.plusDays(1);
            tempPrice1 = tempPrice1 * (1 + interestRate);
            tempPrice2 = tempPrice1 * (1 + interestRate2);
            tempPath1.add(new DPPoint(tempTime,tempPrice1));
            tempPath2.add(new DPPoint(tempTime,tempPrice2));
        }
    }


    /**
     * This method is testing the Brownian Stock Path
     */
    @Test
    public void testBrownianPath(){
        double priceValue = 152.35;
        double rateValue = 0.0001;
        double sigmaValue = 0.01;
        int numberOfDays = 252;

        GuassianRandomVeriableGenerator adGen = Mockito.mock(GuassianRandomVeriableGenerator.class);
        when(adGen.getVector()).thenReturn(new double[]{1.356,-2.18,-1.793,2.648});
        StockPath testBrownian = new BrownianStockPathGenerator(adGen,priceValue,rateValue,sigmaValue,numberOfDays);
        List<DPPoint> testList = testBrownian.getPrices();

        assertEquals(150.30559256756558,testList.get(0).getPriceValue(),0.0);
        assertEquals(153.6259121581384,testList.get(1).getPriceValue(),0.0);
        assertEquals(156.41308768049075,testList.get(2).getPriceValue(),0.0);
        assertEquals(152.33324242168374,testList.get(3).getPriceValue(),0.0);
        assertEquals(4,testList.size(),0.0);
    }

    /**
     * This method is testing the CallOptionPayout
     */
    @Test
    public void testEuropeanCallPayOut(){
        BrownianStockPathGenerator paths = Mockito.mock(BrownianStockPathGenerator.class) ;
        when(paths.getPrices()).thenReturn(tempPath1).thenReturn(tempPath2);
        Payout payOut = new CallOptionPayout(strikePriceValue);
        assertEquals(134.37424601000026, payOut.getPayout(paths),0.0);
        assertEquals(134.63362025601026, payOut.getPayout(paths),0.0);
    }

    /**
     * This method is testing the AsianCallPayout
     */
    @Test
    public void testAsianCallPayOut(){
        BrownianStockPathGenerator paths = mock(BrownianStockPathGenerator.class) ;
        when(paths.getPrices()).thenReturn(tempPath1).thenReturn(tempPath2);
        Payout payOut = new AsianCallPayout(strikePriceValue);
        assertEquals(50.311670611000125, payOut.getPayout(paths), 0.0);
        assertEquals(50.48698228161109, payOut.getPayout(paths), 0.0);
    }


}