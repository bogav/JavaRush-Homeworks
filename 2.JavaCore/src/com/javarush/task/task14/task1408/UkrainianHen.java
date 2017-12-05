package com.javarush.task.task14.task1408;

/**
 * Created by Admin on 28.04.2017.
 */
public class UkrainianHen extends Hen {
    private int eggs = 31;

    public int getCountOfEggsPerMonth(){
        return eggs;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
