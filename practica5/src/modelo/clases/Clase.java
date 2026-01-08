package modelo.clases;

import modelo.Personaje;
//esta interfaz clase hace de padre de las subclases, en ella tendrá 2 métodos que tenemos que definir en cada una de las subclases
//agregarBonificación Clase servirá para aumentar las estadísticas que tiene cada uno como bono y agregar habilidad agrega las modelo.habilidades
//que le pertenecen a cada clase, no tiene sentido que un mago pueda hacer golpe fuerte al igual que un guerrero curación mayor
public interface Clase {
    void agregarBonificacionClase(Personaje personaje);
    void agregarHabilidad(Personaje personaje);
}
