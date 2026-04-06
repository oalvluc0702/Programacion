package rpg.model;

public class Habilidades {
    private int id;
    private String nombre;
    private int danioBase;
    private int usosMaximos;
    private int id_clase;

    public Habilidades(int id, String nombre, int danioBase, int usosMaximos, int id_clase) {
        this.id = id;
        this.nombre = nombre;
        this.danioBase = danioBase;
        this.usosMaximos = usosMaximos;
        this.id_clase = id_clase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }

    public int getUsosMaximos() {
        return usosMaximos;
    }

    public void setUsosMaximos(int usosMaximos) {
        this.usosMaximos = usosMaximos;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    @Override
    public String toString() {
        return "Habilidades{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", danioBase=" + danioBase +
                ", usosMaximos=" + usosMaximos +
                ", id_clase=" + id_clase +
                '}';
    }
}
