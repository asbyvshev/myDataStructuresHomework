package ru.geekbrains.datastructure.lesson5.myhomework;

public class thing{

    private String name;
    private int weight;
    private int price;

    public thing(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if(getClass() != obj.getClass())
            return false;
        else
        {
            thing tmp = (thing) obj;
            if(tmp.weight == this.weight && tmp.price == this.price)
                return true;
            else
                return false;
        }
    }
}
