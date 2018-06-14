package automatas.meraki;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public abstract class Regla {

    private List<Token> tokens;
    private String identificador;

    public Regla(String nombre, List<Token> tokens) {
        this.tokens = tokens;
        this.identificador = nombre;
    }

    public Regla() {

    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public String getNombre() {
        return identificador;
    }

    public void setNombre(String nombre) {
        this.identificador = nombre;
    }
}
