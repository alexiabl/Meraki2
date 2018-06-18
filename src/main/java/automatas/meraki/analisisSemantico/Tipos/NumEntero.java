package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.Expresion;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class NumEntero extends NumeroTipo {

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

    public String getIdentificador() {
        return super.getIdentificador();
    }

    public String  getValorR(){return "T";}
}
