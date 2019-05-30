package com.company;

import com.company.Animals.*;

import java.lang.annotation.Annotation;
import java.security.PublicKey;
import java.util.LinkedList;

public class Main {
    public static void main(String args[]) {
        Begemote b = new Begemote("Begemote");
        Giraffe g = new Giraffe();
        Kote k = new Kote();
        Nosoroge n = new Nosoroge();
        Slone s = new Slone();
        Animal[] animals = new Animal[]{b, g, k, n, s};

        for (Animal animal : animals) {
            show(animal);
        }
    }


    public static void show(Animal animal) {
        Class gc = animal.getClass();
        Annotation[] annotations = gc.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName());
            if (annotation instanceof Mammal) {
                Mammal m = (Mammal) (annotation);
                System.out.println(m.color());
                System.out.println(m.sound());
            }
        }
    }
}
