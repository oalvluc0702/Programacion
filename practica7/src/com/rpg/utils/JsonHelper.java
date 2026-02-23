package com.rpg.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class JsonHelper {
    public JsonHelper() {
    }

    public <T> List<T> readlist(String path, Class<T> tClass){
        try (Reader reader = new FileReader(path)){

        } catch (IOException e){
            System.out.println("no se ha encontrado el archivo");
        }
    }
}
