package hw2;

import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit test for DPPointTest class
 * @author Hui Duan
 */
public class DPPointTest {

    /*dt1 = 2017-10-20T12:00:00.000-04:00
    * dt2 = 2017-10-21T12:00:00.000-04:00
    * dt3 = 2017-10-24T12:00:00.000-04:00
    * dt4 = 2017-10-26T12:00:00.000-04:00
    */
    private DateTime dt1 = new DateTime(2017, 10, 20, 12, 0, 0, 0);
    private DateTime dt2 = dt1.plusDays(1);
    private DateTime dt3 = dt2.plusDays(3);
    private DateTime dt4 = dt3.plusDays(2);

    /* p1 = 153.5
    * p2 = 169.5
    * p3 = 176.3
    * p4 = 147.56
    */
    private double p1 = 153.5;
    private double p2 = 169.5;
    private double p3 = 176.3;
    private double p4 = 147.6;

    /*initialize the object*/
    private DPPoint point1 = new DPPoint(dt1,p1);
    private DPPoint point2 = new DPPoint(dt2,p2);
    private DPPoint point3 = new DPPoint(dt3,p3);
    private DPPoint point4 = new DPPoint(dt4,p4);

    /**
     * Testing for getDataValue() method
     * @throws Exception
     */
    @Test
    public void getDateValue() throws Exception {
        assertEquals(dt1,point1.getDateValue());
        assertEquals(dt2,point2.getDateValue());
        assertEquals(dt3,point3.getDateValue());
        assertEquals(dt4,point4.getDateValue());
    }

    /**
     * Testing for getPriceValue() method
     * @throws Exception
     */
    @Test
    public void getPriceValue() throws Exception {
        assertEquals(p1,point1.getPriceValue(),0.0);
        assertEquals(p2,point2.getPriceValue(),0.0);
        assertEquals(p3,point3.getPriceValue(),0.0);
        assertEquals(p4,point4.getPriceValue(),0.0);
    }

}