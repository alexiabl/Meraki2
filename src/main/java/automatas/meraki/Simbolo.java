package automatas.meraki;


public class Simbolo {

    private String nombre;
    private int linea;

    public Simbolo() {

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getLinea() {
        return this.linea;
    }

}
