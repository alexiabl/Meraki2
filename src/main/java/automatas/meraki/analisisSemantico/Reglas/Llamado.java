package automatas.meraki.analisisSemantico.Reglas;

import automatas.meraki.analisisSemantico.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class Llamado implements Regla {

    private List<Item> tokens;
    private List<Item> expresiones;
    private String identificador;
    private int scope;

    public Llamado(String id) {
        this.identificador = id;
        this.tokens = new LinkedList<Item>();
        this.expresiones = new LinkedList<Item>();
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

    public List<Item> getExpresiones() {
        return this.expresiones;
    }

    public void setExpresiones(List<Item> expresiones) {
        this.expresiones = expresiones;
    }

    public void setScope(int nivel){this.scope = nivel;}

    public int getScope() {return this.scope;}
}
