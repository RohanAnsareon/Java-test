package com.company;

import java.util.Scanner;

enum Season {
    WINTER, SPRING
}

public class Main {

    public static void main(String[] args) {
        TreeSet<Student> treeSet =
                new TreeSet<Student>((value1, value2) -> value1.name.compareTo(value2.name) >= 0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter exit to exit or just press Ентер to continue...");
            if(scanner.nextLine().equalsIgnoreCase("exit")) break;
            System.out.println("Enter user's name:");
            String name = scanner.nextLine().trim();
            System.out.println("Enter user's surname:");
            String surname = scanner.nextLine().trim();
            System.out.println("Enter user's average point:");
            double averagePoint;
            try {
                averagePoint = Double.parseDouble(scanner.nextLine().trim());
            } catch (Exception e) {
                for (int i = 1; i < 100; i++) System.out.println();
                System.out.println("Enter only double values in average point.");
                continue;
            }
            if(treeSet.add(new Student(name, surname, averagePoint))) {
                for (int i = 1; i < 100; i++) {
                    System.out.println();
                }
                System.out.println("Your user has been added successfully!");
            } else {
                for (int i = 1; i < 100; i++) {
                    System.out.println();
                }
                System.out.println("Sorry, but your user has not been added successfully!");

            }
        }
    }
}
