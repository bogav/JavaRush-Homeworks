package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import com.sun.org.apache.bcel.internal.Constants;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static  {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        public String getCompanyName() { //example JavaRush Ltd.
            return data.getCompany();
        }

        public String getCountryName() { //Ukraine
            return countries.get(data.getCountryCode());
        }

        public String getName() { //Ivanov, Ivan
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        public String getPhoneNumber() { //+38(050)123-45-67
            String s = "" + data.getPhoneNumber();
            while (s.length()<10) s = "0" + s;

            return String.format( "+%d(%s)%s-%s-%s",
                    data.getCountryPhoneCode(),
                    s.substring(0, 3),
                    s.substring(3, 6),
                    s.substring(6, 8),
                    s.substring(8, 10) );
        }

    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}