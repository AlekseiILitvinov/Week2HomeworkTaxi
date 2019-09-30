import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxiServiceTest {

    @Test
    void calculateFarePriceInt() {
        TaxiService taxiService = new TaxiService();

        int actual = taxiService.calculateFarePrice(50);
        int expected = 60 + 20 * 50;
        assertEquals(expected, actual);
    }

    @Test
    void calculateFarePriceDoubleWithRoundingUp() {
        TaxiService taxiService = new TaxiService();

        int actual = taxiService.calculateFarePrice(10.01);
        int expected = 261;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDiscountRoundDown() {
        TaxiService taxiService = new TaxiService();

        int actual = taxiService.calculateDiscount(1005);
        int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDiscountNotEnough() {
        TaxiService taxiService = new TaxiService();

        int actual = taxiService.calculateDiscount(999);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateDiscountOverfilled() {
        TaxiService taxiService = new TaxiService();

        int actual = taxiService.calculateDiscount(3000);
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void totalPriceDefaultService() {
        TaxiService taxiService = new TaxiService();

        int actual = taxiService.totalPrice(70.05);
        int expected = 1388;
        assertEquals(expected, actual);
    }

    @Test
    void totalPriceOtherService() {
        TaxiService taxiService = new TaxiService(100, 20, 500, 5, 200);

        int actual = taxiService.totalPrice(70.05);
        int expected = 1426;
        assertEquals(expected, actual);
    }
}