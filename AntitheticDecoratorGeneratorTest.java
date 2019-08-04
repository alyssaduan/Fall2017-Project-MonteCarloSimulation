package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit test for AntitheticDecoratorGenerator class
 * @author Hui Duan
 */

public class AntitheticDecoratorGeneratorTest {
    /* we are using 150 as the value of numberOfdays for testing*/
    private int numberOfdays = 150;

    /*initialize the object of GuassianRandomVeriableGenerator*/
    private GuassianRandomVeriableGenerator grvGenerator = new GuassianRandomVeriableGenerator(numberOfdays);

    /*initialize the object of AntitheticDecoratorGenerator*/
    private AntitheticDecoratorGenerator adGenerator = new AntitheticDecoratorGenerator(grvGenerator);

    /**
     * Testing method for getVector, to see if the size of random vector is equals to the numberOfdays
     * @see AntitheticDecoratorGenerator class
     */
    @Test
    public void getVector() throws Exception {
        assertEquals(numberOfdays,adGenerator.getVector().length);
    }

}