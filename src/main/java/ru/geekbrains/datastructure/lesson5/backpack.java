package ru.geekbrains.datastructure.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backpack {

    private static final int MAX_WEIGHT;

    static {
        MAX_WEIGHT = 8;
    }

    private int maxPrice;
    private List<thing> things = new ArrayList<thing>();
    private List<thing> result = null;

    public backpack(thing ... things) {
        this.things = Arrays.asList(things);
    }

    public void stack(){
        if (things.size() > 0){

        }

    }

    private void rotate(int length){}

    public void info(){
        for (thing t:result) {
            System.out.println(t.getName() + " вес: " + t.getWeight()
                    + " цена: " + t.getPrice());
        }
    }
}
