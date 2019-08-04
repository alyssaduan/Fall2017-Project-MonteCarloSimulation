package hw2;

/**
 * The interface of calculate the payout, the returned double should be the
 * payout after each simulation
 * @author Hui Duan
 */
public interface Payout {
    /**
     * getPayout() methods for each class should return the payout after each simulation
     * @param path The Brownian Stock Path
     * @return double The payout for different classes
     * @see CallOptionPayout
     * @see AsianCallPayout
     */
    double getPayout(StockPath path);
}
