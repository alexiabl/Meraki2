package automatas.meraki;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Regla {

    private List<Token> tokens;
    private String nombre;

    public Regla(String nombre, List<Token> tokens) {
        this.tokens = tokens;
        this.nombre = nombre;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
