package com.github.abigailfails.animals.animal;

public class Duck extends Animal {

    public Duck(String state, int size) {
        super(state, size);
    }

    @Override
    public void feed() {
        super.feed();
        if (size > 5) state = "BIG DUCK";
    }

    public void quack() {
        state += " QUACKING";
    }

}
