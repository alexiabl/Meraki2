package automatas.meraki.analisisSemantico.Reglas;

import automatas.meraki.analisisSemantico.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/18/18.
 */
public class Iteracion implements Regla {

    private String identificador;
    private List<Item> tokens;
    private List<Item> indicaciones;

    public Iteracion(String id) {
        this.identificador = id;
        this.tokens = new LinkedList<Item>();
        this.indicaciones = new LinkedList<Item>();
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

    public List<Item> getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(List<Item> indicaciones) {
        this.indicaciones = indicaciones;
    }
}
