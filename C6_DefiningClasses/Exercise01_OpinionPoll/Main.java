package C6_DefiningClasses.Exercise01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] token = scanner.nextLine().split("\\s+");

            String name = token[0];
            int age = Integer.parseInt(token[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }

        personList
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(person -> person.getAge() > 30)
                .forEach(System.out::println);
    }
}
