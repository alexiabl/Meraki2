package automatas.meraki.analisisSemantico.Operaciones;

import automatas.meraki.analisisSemantico.Expresion;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class OperacionMultiplicacion implements Expresion {
    private Expresion ladoIzq, ladoDer;

    public OperacionMultiplicacion(Expresion ladoIzq, Expresion ladoDer) {
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
