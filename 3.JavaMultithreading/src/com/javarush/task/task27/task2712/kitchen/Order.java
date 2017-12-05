package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

import static com.javarush.task.task27.task2712.ConsoleHelper.getAllDishesForOrder;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int result = 0;
        for (Dish item: dishes)
            result += item.getDuration();
        return result;
    }

    public boolean isEmpty(){
        if (dishes.isEmpty()) return true; else
            return false;
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }

}
