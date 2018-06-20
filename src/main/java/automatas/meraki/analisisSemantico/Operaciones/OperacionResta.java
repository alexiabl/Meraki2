package automatas.meraki.analisisSemantico.Operaciones;

import automatas.meraki.analisisSemantico.Expresion;
import automatas.meraki.analisisSemantico.Item;
import automatas.meraki.analisisSemantico.Reglas.Regla;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class OperacionResta implements Regla {
    private Expresion ladoIzq, ladoDer;
    private List<Item> tokens;
    private List<Item> indicaciones;
    private String identificador;

    public OperacionResta(Expresion ladoIzq, Expresion ladoDer) {
        this.ladoDer = ladoDer;
        this.ladoIzq = ladoIzq;
    }

    public Expresion getLadoIzq() {
        return this.ladoIzq;
    }

    public Expresion getLadoDer() {
        return this.ladoDer;
    }

    public void setLadoIzq(Expresion ladoIzq) {
        this.ladoIzq = ladoIzq;
    }

    public void setLadoDer(Expresion ladoDer) {
        this.ladoDer = ladoDer;
    }

    public List<Item> getTokens() {
        return this.tokens;
    }

    public void setTokens(List<Item> tokens) {
        this.tokens = tokens;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String nombre) {
        this.identificador = nombre;
    }

    public void agregarATokens(Item tok) {
        this.tokens.add(tok);
    }
}
