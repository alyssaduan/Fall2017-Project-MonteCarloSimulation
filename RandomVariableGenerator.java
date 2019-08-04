package hw2;

/**
 * The interface of generating the random vectors, the returned double[] should be the
 * vector of standard normally distributed numbers.
 * @author Hui Duan
 */
public interface RandomVariableGenerator {
    /**
     * getVector() methods for each class should return the vector of standard normally distributed numbers
     * @return double[] The vector that contains normally distributed numbers
     * @see GuassianRandomVeriableGenerator
     * @see AntitheticDecoratorGenerator
     */
    double[] getVector();
}
