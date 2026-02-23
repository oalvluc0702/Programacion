package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHelper {
    public JsonHelper() {
    }

    public <T> List<T> readlist(String path, Class<T> tClass){
        try (Reader reader = new FileReader(path)){
            Type typetoken = TypeToken.getParameterized(List.class, tClass).getType();
            Gson gson = new Gson();
            return  gson.fromJson(reader, typetoken);
        } catch (IOException e){
            System.out.println("no se ha encontrado el archivo");
            return List.of();
        }
    }
}
