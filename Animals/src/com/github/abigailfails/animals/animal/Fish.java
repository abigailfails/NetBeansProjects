package com.github.abigailfails.animals.animal;

public class Fish extends Animal {

    private int maxSize;

    public Fish(String state, int size) {
        super(state, size);
        maxSize = 2;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void feed() {
        size += 2;
        if (size >= maxSize) {
            state = "BIG FISH";
        }
    }
}
