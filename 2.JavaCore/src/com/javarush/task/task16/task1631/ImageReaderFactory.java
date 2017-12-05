package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Admin on 11.05.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes s) {
        if ( s == ImageTypes.JPG ) return new JpgReader();
        if ( s == ImageTypes.PNG ) return new PngReader();
        if ( s == ImageTypes.BMP ) return new BmpReader();

        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
