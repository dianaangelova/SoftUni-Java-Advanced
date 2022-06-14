package C7_Generics.Exercise05_GenericCountMethodString;

import java.util.*;
import java.util.stream.Collectors;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public List<T> getValues() {
        return values;
    }

    public void add(T element) {
        values.add(element);
    }

    public void swapElements(int first, int second) {
        Collections.swap(values, first, second);
    }

    public int countString(T element) {

        return (int) values.stream().filter(itemFromOurBox -> itemFromOurBox.compareTo(element) > 0).count();

    }

}
