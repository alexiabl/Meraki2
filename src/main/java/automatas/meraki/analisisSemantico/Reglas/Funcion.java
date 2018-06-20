package automatas.meraki.analisisSemantico.Reglas;

import automatas.meraki.analisisSemantico.Expresion;
import automatas.meraki.analisisSemantico.Item;
import automatas.meraki.analisisSemantico.Token;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Funcion implements Regla {

    private String identificador;
    private List<Item> tokens;
    private List<Item> indicaciones; //para las asignaciones, mientras, declaraciones (bloquecodigo) dentro de una funcion

    public Funcion(String id) {
        this.identificador = id;
        this.tokens = new LinkedList<Item>();
        this.indicaciones = new LinkedList<Item>();
    }

    public List<Item> getTokens() {
        return tokens;
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

    public void setIndicaciones(List<Item> indicaciones) {
        this.indicaciones = indicaciones;
    }

    public List<Item> getIndicaciones() {
        return this.indicaciones;
    }
}
