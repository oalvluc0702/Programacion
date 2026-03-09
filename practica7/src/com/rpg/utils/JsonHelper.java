package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
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
    public <T> void writeList(String path, List<T> lista) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new Gson();
            gson.toJson(lista, writer);
            System.out.println("JSON escrito correctamente en " + path);
        } catch (IOException e) {
            System.out.println("No se ha podido escribir el archivo: " + path);
        }
    }

}
