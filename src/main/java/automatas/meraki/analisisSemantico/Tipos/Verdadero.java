package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.Expresion;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Verdadero implements Expresion {

    private boolean valor;

    public Verdadero(boolean val) {
        this.valor = val;
    }

    public boolean getValor() {
        return valor;
    }
}
