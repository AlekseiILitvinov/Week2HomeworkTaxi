public class TaxiService {
    private int boardingPrice = 60;
    private int pricePerKilometer = 20;
    private int discountThreshold = 1_000;
    private int discountPercent = 5;
    private int discountMax = 100;

    public TaxiService() {
    }
    
    public TaxiService(int boardingPrice, int pricePerKilometer, int discountThreshold, int discountPercent, int discountMax) {
        this.boardingPrice = boardingPrice;
        this.pricePerKilometer = pricePerKilometer;
        this.discountThreshold = discountThreshold;
        this.discountPercent = discountPercent;
        this.discountMax = discountMax;
    }

    /**
     * The prices is rounded up to the rouble.
     *
     * @param distance Distance in kilometers
     * @return Price without discount rounded up to roubles.
     */
    public int calculateFarePrice(double distance) {
        return boardingPrice + (int) Math.ceil(distance * pricePerKilometer);
    }

    /**
     * The discount is rounded down.
     *
     * @param price The price without discount
     * @return The resulting discount
     */
    public int calculateDiscount(int price) {
        int discount = 0;
        if (price > discountThreshold) {
            discount = discountPercent * price / 100;
            if (discount > discountMax) {
                discount = discountMax;
            }
        }
        return discount;
    }
}
