package C7_Generics.Lab01_Jar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> integerJar = new Jar<>();

        integerJar.add(12);
        integerJar.add(56);

        System.out.println(integerJar.remove());
        System.out.println(integerJar.remove());

    }
}
