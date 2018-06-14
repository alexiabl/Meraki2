package automatas.meraki.analisisSemantico.Comparaciones;

import automatas.meraki.analisisSemantico.Expresion;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class Igual implements Comparacion {
    private Expresion ladoIzq, ladoDer;

    public Igual(Expresion ladoIzq, Expresion ladoDer) {
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
}
