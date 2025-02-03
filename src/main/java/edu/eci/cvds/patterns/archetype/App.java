package edu.eci.cvds.patterns.archetype;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if (args.length > 0) {
            String fullName = String.join(" ", args);
            System.out.println("Hello, " + fullName + "!");
        } else {
            System.out.println("Hello World!");
        }
    }
}
