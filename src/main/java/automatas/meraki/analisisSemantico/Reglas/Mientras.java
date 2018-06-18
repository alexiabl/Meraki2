package automatas.meraki.analisisSemantico.Reglas;

import automatas.meraki.analisisSemantico.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/18/18.
 */
public class Mientras implements Regla {

    private List<Item> tokens;
    private List<Item> indicaciones;
    private String identificador;

    public Mientras(String id) {
        this.identificador = id;
        this.tokens = new LinkedList<Item>();
        this.indicaciones = new LinkedList<Item>();
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

    public List<Item> getTokens() {
        return this.tokens;
    }

    public void setIndicaciones(List<Item> indicaciones) {
        this.indicaciones = indicaciones;
    }

    public List<Item> getIndicaciones() {
        return this.indicaciones;
    }

}
