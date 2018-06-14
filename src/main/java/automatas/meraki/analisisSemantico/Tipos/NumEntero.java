package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.Expresion;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class NumEntero implements Expresion {

    private int valor;

    public NumEntero(int val) {
        this.valor = val;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
