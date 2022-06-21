package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public String name;
    public int capacity;
    public List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (getCount() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        //removes a person by given name, if such exists, and returns boolean
        boolean personExists = false;
        Person person = null;
        for (Person p : roster) {
            if (p.getName().equals(name)) {
                person = p;
                personExists = true;
            }
        }
        if (personExists) {
            roster.remove(person);
        }

        return personExists;
    }

    public Person getPerson(String name, String hometown) {
        //returns the people with the given name and hometown or null if there is no such person
        //String personPrint = null;
        Person person = null;
        for (Person p : roster) {
            if (p.name.equals(name) && p.hometown.equals(hometown)) {
                //personPrint = p.toString();
                person = p;
            }
        }
        return person;
    }

    public int getCount() {
        int count = 0;

        for (Person p : roster) {
            count++;
        }

        return count;
    }

    public String getStatistics() {
        //returns a String in the following format:
        //    o	"The people in the hotel {name} are:
        //    {Person1}
        //    {Person2}
        //(…)"
        List<String> outputList = new ArrayList<>();
        String outputMessage = "The people in the hotel " + name + " are:";
        outputList.add(outputMessage);

        for (Person p : roster) {
            outputMessage = p.toString();
            outputList.add(outputMessage);
        }
        return (String.join(System.lineSeparator(), outputList));
    }


}
