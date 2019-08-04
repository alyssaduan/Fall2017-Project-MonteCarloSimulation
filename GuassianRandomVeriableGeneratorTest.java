package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit test for GuassianRandomVeriableGenerator class
 * @author Hui Duan
 * @see RandomVariableGenerator
 */

public class GuassianRandomVeriableGeneratorTest {
    /* we are using 252 as the value of numberOfdays for testing*/
    private int numberOfdays = 252;

    /*initialize the object of GuassianRandomVeriableGenerator class called grvGenerator*/
    private GuassianRandomVeriableGenerator grvGenerator = new GuassianRandomVeriableGenerator(numberOfdays);

    /**
     * Testing method for getVector, to see if the size of random vector is equals to the numberOfdays
     * @see GuassianRandomVeriableGenerator class
     */
    @Test
    public void getVector() throws Exception {
        assertEquals(numberOfdays, grvGenerator.getVector().length);
    }

}