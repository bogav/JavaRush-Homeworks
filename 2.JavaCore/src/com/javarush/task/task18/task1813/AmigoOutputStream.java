package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    private FileOutputStream original;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream (FileOutputStream outputStream) throws FileNotFoundException{
        super(fileName);
        this.original = outputStream;
    }

    public void write(int b) throws IOException{original.write(b);}

    public void write(byte[] b) throws IOException{ original.write(b); }

    public void write(byte[] bytes, int i, int i1) throws IOException {
        original.write(bytes, i, i1);
    }

    public void flush() throws IOException{
        original.flush();
    }

    public void close() throws IOException{
        flush();
        /*StringBuilder sb = new StringBuilder();
        sb.append("JavaRush © All rights reserved."); */
        String s = "JavaRush © All rights reserved.";//sb.toString();
        write(s.getBytes());
        original.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
