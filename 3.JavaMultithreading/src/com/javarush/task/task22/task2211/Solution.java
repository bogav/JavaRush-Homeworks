package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(args[0]), "utf-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(args[1]), "windows-1251");

        while (inputStreamReader.ready()) {
            outputStreamWriter.write( inputStreamReader.read() );
        }
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}
