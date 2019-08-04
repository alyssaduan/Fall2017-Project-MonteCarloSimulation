package hw2;

import java.util.Random;

/**
 * This is the GuassianRandomVeriableGenerator class implementing RandomVariableGenerator interface
 * @author Hui Duan
 */

public class GuassianRandomVeriableGenerator implements RandomVariableGenerator {

    /* Creating objects*/
    private Random randGenerator;
    private int numbOfDays;

    /**
     * Construct the GuassianRandomVeriableGenerator and create new Random() object
     * @param numbOfDays The Number of days that the program will use to generate same amount of random variables
     */
    public GuassianRandomVeriableGenerator(int numbOfDays){
        this.numbOfDays = numbOfDays;
        randGenerator = new Random();
    }

    /**
     * getVector() method will use nextGaussian() function to generate same amount of standard normally distributed numbers.
     * @return doube[] The vector that contains all the random variables
     */
    public double[] getVector()
    {
        double[] probabilities = new double[numbOfDays];
        for (int i =0; i<numbOfDays; i++)
        {
            double temp = randGenerator.nextGaussian();
            probabilities[i] = temp;
        }
        return probabilities;
    }
}
