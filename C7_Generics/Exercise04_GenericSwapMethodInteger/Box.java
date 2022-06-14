package C7_Generics.Exercise04_GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public void swapElements( int first, int second){
        Collections.swap(values, first, second);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T value : values) {
            stringBuilder.append(String.format("%s: %s%n", value.getClass().getName(), value.toString()));
        }
        return stringBuilder.toString();
    }
}
