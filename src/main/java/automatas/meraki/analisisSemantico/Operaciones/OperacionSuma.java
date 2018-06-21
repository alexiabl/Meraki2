package automatas.meraki.analisisSemantico.Operaciones;

import automatas.meraki.analisisSemantico.Expresion;
import automatas.meraki.analisisSemantico.Item;
import automatas.meraki.analisisSemantico.Reglas.Regla;
import automatas.meraki.analisisSemantico.Tipos.Tipo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class OperacionSuma implements Regla {
    private Tipo ladoIzq, ladoDer;

    public OperacionSuma(Tipo ladoIzq, Tipo ladoDer) {
        this.ladoDer = ladoDer;
        this.ladoIzq = ladoIzq;
    }

    public Tipo getLadoIzq() {
        return this.ladoIzq;
    }

    public Tipo getLadoDer() {
        return this.ladoDer;
    }

    public void setLadoIzq(Tipo ladoIzq) {
        this.ladoIzq = ladoIzq;
    }

    public void setLadoDer(Tipo ladoDer) {
        this.ladoDer = ladoDer;
    }

    private List<Item> tokens;
    private List<Item> expresiones;
    private String identificador;

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

    public OperacionSuma(String id) {
        this.identificador = id;
        this.tokens = new LinkedList<Item>();
        this.expresiones = new LinkedList<Item>();
    }


}

