package hw2;

import java.util.List;

/**
 * The interface of generating the simulate stock paths, the returned List<DPPoint> should be the
 * list of Date-Price Points
 * @author Hui Duan
 */
public interface StockPath {
    /**
     * getPrices() method will contains all the DPPoint objects and return a list of simulate path
     * @return List<DPPoint> The list of simulation path
     * @see BrownianStockPathGenerator
     */
    List<DPPoint> getPrices();
}
