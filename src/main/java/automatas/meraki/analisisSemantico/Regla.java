package automatas.meraki.analisisSemantico;

import java.util.LinkedList;
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
        tokens = new LinkedList<Token>();
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String nombre) {
        this.identificador = nombre;
    }
}
