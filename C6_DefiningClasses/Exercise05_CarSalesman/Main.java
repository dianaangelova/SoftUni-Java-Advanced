package C6_DefiningClasses.Exercise05_CarSalesman;


import java.util.*;

public class Main {
    public static <engineList> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberEngine = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        //Map<Engine, Car> map = new LinkedHashMap<>();
        Engine engine = null;


        for (int i = 0; i < numberEngine; i++) {
            String[] tokensEngine = scanner.nextLine().split("\\s+");
            String model = tokensEngine[0];
            int power = Integer.parseInt(tokensEngine[1]);
            // "{Model} {Power} {Displacement} {Efficiency}
            if (tokensEngine.length == 2) {
                engine = new Engine(model, power);
            } else if (tokensEngine.length == 3) {
                if (tokensEngine[2].chars().allMatch(Character::isDigit)) {
                    int displacement = Integer.parseInt(tokensEngine[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokensEngine[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else if (tokensEngine.length == 4) {
                int displacement = Integer.parseInt(tokensEngine[2]);
                String efficiency = tokensEngine[3];
                engine = new Engine(model, power, displacement, efficiency);
            }
           // if (engine != null && !map.containsKey(engine)) {
                engineList.add(engine);
          //      map.put(engine, null);
        //    }
        }

        int numberCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberCars; i++) {
            String[] tokensCar = scanner.nextLine().split("\\s+");
//"{Model} {Engine} {Weight} {Color}
            String model = tokensCar[0];
            String engineI = tokensCar[1];
            Car car = null;
            if (tokensCar.length == 2) {
                car = new Car(model, engineI);
            } else if (tokensCar.length == 3) {
                if (tokensCar[2].chars().allMatch(Character::isDigit)) {
                    int weight = Integer.parseInt(tokensCar[2]);
                    car = new Car(model, engineI, weight);
                } else {
                    String color = tokensCar[2];
                    car = new Car(model, engineI, color);
                }
            } else if (tokensCar.length == 4) {
                int weight = Integer.parseInt(tokensCar[2]);
                String color = tokensCar[3];
                car = new Car(model, engineI, weight, color);
            }
            carList.add(car);
        }
        for (Car c : carList) {
            for (Engine e : engineList) {
                if (c.getEngine().equals(e.getModel())) {
                    //map.put(engine, car);
                    System.out.println(c.getModel()+":");
                    System.out.println(c.getEngine()+":");
                    System.out.println("Power: " + e.getPower());
                    if (e.getDisplacement()==0){
                        System.out.println("Displacement: n/a");

                    }else{
                        System.out.println("Displacement: " + e.getDisplacement());

                    }
                    System.out.println("Efficiency: " + e.getEfficiency());
                    if (c.getWeight()==0){
                        System.out.println("Weight: n/a");

                    }else{
                        System.out.println("Weight: " + c.getWeight());

                    }
                    System.out.println("Color: " + c.getColor());
                }
            }
        }
    }
}

