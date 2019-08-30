package ru.geekbrains.datastructure.lesson5.myhomework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backpack {

    private static final int MAX_WEIGHT;

    static {
        MAX_WEIGHT = 8;
    }

    private int maxPrice;
    private List<thing> AllThings;
    private List<thing> result = null;

    public backpack(thing ... things) {
        this.AllThings = new ArrayList<>(Arrays.asList(things));
    }


    public void stack(){

        stack(AllThings);

        for (thing t:result) {
            System.out.println(t.getName() + " вес: " + t.getWeight()
                    + " цена: " + t.getPrice());
        }
    }

    public void stack(List<thing> things){

        if (things.size() > 0){
            bestStack(things);
        }

        for (int i = 0; i < things.size(); i++){
            List<thing> list = new ArrayList<>(things);
            list.remove(i);
            stack(list);
        }

    }

    private void bestStack(List<thing> things) {
        if (result == null){
            if (calcWeigth(things) <= MAX_WEIGHT){
                result = things;
                maxPrice = calcPrice(things);
            }
        } else {
           if (calcWeigth(things) <= MAX_WEIGHT && calcPrice(things) > maxPrice){
               result = things;
               maxPrice = calcPrice(things);
           }
        }
    }

    private int calcWeigth (List<thing> things){
        int sumWeigth = 0;
        for (thing t: things) {
            sumWeigth += t.getWeight();
        }
        return sumWeigth;
    }

    private int calcPrice (List<thing> things){
        int sumPrice = 0;
        for (thing t: things) {
            sumPrice += t.getPrice();
        }
        return sumPrice;
    }

}
