package task1;

import java.util.Comparator;

public class Tablet {
    private final String name;
    private final int memory;
    private final int rate;
    private final double price;

    public Tablet(String name, int memory, int rate, double price) {
        this.name = name;
        this.memory = memory;
        this.rate = rate;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + memory + ", " + rate + ", " + price;
    }

    public String getName() {
        return name;
    }

    public int getMemory() {
        return memory;
    }

    public int getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }

//    public int compare(task1.Tablet o1, task1.Tablet o2) {
//        if (o1.getMemory() == o2.getMemory()){
//            return 0;
//        } else if (o1.getMemory() < o2.getMemory()) {
//            return -1;
//        } else return 1;
//    }
}
