package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return data.removeIf(egg -> egg.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        Comparator<Egg> comparator = Comparator.comparing(Egg::getStrength);
        Egg strongestEgg = data.stream().max(comparator).get();
        return strongestEgg;
    }

    public Egg getEgg(String color) {

        return data.stream().filter(egg -> egg.getColor()
                            .equals(color))
                            .findFirst()
                            .orElse(null);
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n", material));
        for (Egg egg : data) {
            sb.append(String.format("%s%n", egg.toString()));
        }
        return sb.toString().trim();

    }

    public int getCount(){
        return data.size();
    }


}
