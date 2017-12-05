package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
/*        Integer[] array = new Integer[]{1, 1, 2, 3, 4, 5};
        array = Solution.sort(array);
        for (Integer item: array )
            System.out.print(item + " ");
            */
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int median;
        if ( (array.length % 2)== 0) median = ( (array[array.length/2] + array[-1+array.length/2])/2 );
        else median = array[array.length/2];

        System.out.println(median);

        Comparator<Integer> compareByInt = new Comparator<Integer>() {
            public int compare(Integer integer, Integer t1) {
                return (int) (Math.abs(median-integer) - Math.abs(median-t1) );
            }
        };

        Arrays.sort(array, compareByInt);
        return array;
    }
}
