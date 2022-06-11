package C6_DefiningClasses.Lab01_Car1;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return "The car is: " +
                brand +" "+ model + " - " +
                horsePower + " HP.";
    }
}
