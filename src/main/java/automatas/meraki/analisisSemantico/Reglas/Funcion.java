package automatas.meraki.analisisSemantico.Reglas;

import automatas.meraki.analisisSemantico.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Funcion implements Regla {

    private String identificador;
    private List<Item> tokens;
    private List<Item> indicaciones; //para las asignaciones, mientras, declaraciones (bloquecodigo) dentro de una funcion
    private List<Item> listaParametros;
    private List<Item> listaDevuelva;

    public Funcion(String id) {
        this.identificador = id;
        this.tokens = new LinkedList<Item>();
        this.indicaciones = new LinkedList<Item>();
    }

    public void setParam(List<Item> listaP) {this.listaParametros = listaP;}

    public void setDev(List<Item> listaD) {this.listaDevuelva = listaD;}

    public List<Item> getParam(List<Item> listaP) {return this.listaParametros;}

    public List<Item> getDev(List<Item> listaD) {return this.listaDevuelva;}

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
