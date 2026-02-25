package com.rpg.services;

import com.rpg.model.Personajes;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    public void cargarTodo(){

    }
    public Personajes crearPersonaje(){
        String nombre;
        String raza;
        List<String> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean finalizar = false;
        System.out.println("Dime el nombre de tu personaje");
        nombre = scanner.nextLine();
        System.out.println("Dime su raza");
        raza = scanner.nextLine();
        while(!finalizar){
            System.out.println("Dime el id del item");
            items.add(scanner.nextLine());
            System.out.println("Quieres seguir añadiendo? 's' para continuar");
            if (!scanner.nextLine().equals("s")) finalizar = true;
        }
        return new Personajes(nombre,raza,0,items);
    }
}
