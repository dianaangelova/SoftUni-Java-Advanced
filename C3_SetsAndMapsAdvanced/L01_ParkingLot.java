package C3_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01_ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {

            String[] inputArray = input.split(", ");
            String direction = inputArray[0];
            String carPlate = inputArray[1];

            if (direction.equals("IN")) {
                cars.add(carPlate);
            } else {
                cars.remove(carPlate);
            }
            input = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else System.out.println(String.join(System.lineSeparator(), cars));
    }
}
