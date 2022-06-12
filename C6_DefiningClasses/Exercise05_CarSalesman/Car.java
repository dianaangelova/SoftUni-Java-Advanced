package C6_DefiningClasses.Exercise05_CarSalesman;

public class Car {
    private String model;
    private String engine;
    private int weight;
    private String color;


    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, String engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, String engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, String engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
