package hotel;

public class Person {

    public String name;
    public int id;
    public int age;
    public String hometown; //"n/a"

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = "n/a";
    }

    public Person(String name, int id, int age, String hometown) {
        this(name, id, age);
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "Person " + name
                + ": " + id
                + ", Age: " + age
                + ", Hometown: " + hometown;
    }
}
