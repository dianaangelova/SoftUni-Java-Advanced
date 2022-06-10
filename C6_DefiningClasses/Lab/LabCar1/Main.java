package C6_DefiningClasses.LabCar1;

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
            String model = token[1];
            int horsePower = Integer.parseInt(token[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carList.add(car);

            token = scanner.nextLine().split("\\s+");
        }


        for (Car c : carList) {
            System.out.println(c.carInfo());
        }
    }
}
