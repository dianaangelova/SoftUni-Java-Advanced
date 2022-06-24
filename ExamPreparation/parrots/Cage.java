package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        boolean parrotExists = false;
        Parrot parrot = null;
        for (Parrot p : data) {
            if (p.getName().equals(name)) {
                parrot = p;
                parrotExists = true;
            }
        }
        if (parrotExists) {
            data.remove(parrot);
        }

        return parrotExists;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = null;
        for (Parrot p : data) {
            if (p.getName().equals(name)) {
                p.setAvailable(false);
                parrot = p;
            }
        }
        return parrot;
    }

    public List sellParrotBySpecies(String species) {
        List<Parrot> outputList = new ArrayList<>();
        Parrot parrot = null;
        for (Parrot p : data) {
            if (p.getSpecies().equals(species)) {
                p.setAvailable(false);
                outputList.add(p);
            }
        }
        return outputList;
    }

    public int count() {
        return data.size();
    }


    public String report() {

        List<String> outputList = new ArrayList<>();
        String outputMessage;
        outputMessage = "Parrots available at " + this.name + ":";
        outputList.add(outputMessage);

        for (Parrot p : data) {
            if (p.isAvailable()) {
                outputList.add(p.toString());
            }
        }
        return (String.join(System.lineSeparator(), outputList));
    }
}
