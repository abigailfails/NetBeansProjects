package com.github.abigailfails.animals.animal;

public abstract class Animal {

    protected String state;
    protected int size;

    public Animal (String state, int size) {
        this.state = state;
        this.size = size;
    }

    public void feed () {
        size++;
    }

    public String getState () {
        return state;
    }

    public int getSize() {
        return size;
    }
}
