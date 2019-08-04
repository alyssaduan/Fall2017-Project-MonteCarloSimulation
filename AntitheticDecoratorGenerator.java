package hw2;

/**
 * This is the AntitheticDecoratorGenerator class implementing RandomVariableGenerator interface
 * @author Hui Duan
 * @see RandomVariableGenerator
 */

public class AntitheticDecoratorGenerator implements RandomVariableGenerator {

    /* Creating objects*/
    private RandomVariableGenerator generator;

    /**
     * Construct the AntitheticDecoratorGenerator, the decorator will negate the vector
     * that generate by GuassianRandomVeriableGenerator to achieve faster convergence.
     * @param vectorGenerator The GuassianRandomVeriableGenerator object
     */
    public AntitheticDecoratorGenerator(RandomVariableGenerator vectorGenerator) {
        this.generator = vectorGenerator;
    }

    /**
     * getVector() method will use the vector that generate from GuassianRandomVeriableGenerator.getVector()
     * function and return the vector after negating it
     * @return doube[] The vector that contains all the random variables after negating
     */
    public double[] getVector() {
        double[] prevVector = generator.getVector();

        for (int i = 0; i< prevVector.length; i++)
        {
            prevVector[i] *= -1;
        }
        return prevVector;
    }

}
