package com.github.abigailfails.animals;

import com.github.abigailfails.animals.animal.Animal;
import com.github.abigailfails.animals.animal.Duck;
import com.github.abigailfails.animals.animal.Fish;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Fish fish = new Fish("little fish", 1);
        fish.setMaxSize(3);
        Duck duck = new Duck("little duck", 1);
        for (int i = 0; i < 5; i++) {
            duck.feed();
            System.out.println(duck.getState());
            fish.feed();
            System.out.println(fish.getState());
        }
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(fish);
        animals.add(duck);
        for (Animal animal : animals) {
            animal.feed();
            if (animal instanceof Fish) {
                ((Fish) animal).setMaxSize(6);
            }
            else if (animal instanceof Duck) {
                ((Duck) animal).quack();
            }
            System.out.println(animal.getState());
        }
    }
}
