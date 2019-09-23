import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaxiService firstTaxiService = new TaxiService();
        TaxiService secondTaxiService = new TaxiService(100, 20, 500, 5, 200);
        TaxiService thirdTaxiService = new TaxiService(20, 25, 2000, 10, 500);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the distance you would like to ride: ");
        double distanceToTravel = Double.parseDouble(scanner.next());

        displayFareInfo("First Service", firstTaxiService, distanceToTravel);
        displayFareInfo("Second Service", secondTaxiService, distanceToTravel);
        displayFareInfo("Third Service", thirdTaxiService, distanceToTravel);
    }

    private static void displayFareInfo(String serviceName, TaxiService service, double distance) {
        String priceAnnouncementFormat = "For a ride of %.1f kilometers the %s charges %d roubles with a " +
                "discount %d. The total price to pay: %d";
        int price = service.calculateFarePrice(distance);
        int discount = service.calculateDiscount(price);
        System.out.println(String.format(priceAnnouncementFormat, distance, serviceName,
                price, discount, (price - discount)));
    }
}
