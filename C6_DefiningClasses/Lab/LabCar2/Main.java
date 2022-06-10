package C6_DefiningClasses.LabCar2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());
        String[] token = scanner.nextLine().split("\\s+");

        List<Car> carList = new ArrayList<>();

        while (carCount-- > 0) {
            String brand = token[0];

            if (token.length == 1) {
                Car car = new Car(brand);
                carList.add(car);

            } else {
                String model = token[1];
                int horsePower = Integer.parseInt(token[2]);
                Car car = new Car(brand, model, horsePower);
                carList.add(car);
            }

            token = scanner.nextLine().split("\\s+");
        }

        for (Car c : carList) {
            System.out.println(c.carInfo());
        }
    }
}
