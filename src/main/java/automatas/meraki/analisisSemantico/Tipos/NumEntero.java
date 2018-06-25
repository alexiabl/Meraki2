package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.Expresion;
import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class NumEntero extends Tipo {

    public int valor;
    private TipoTokenTerminal tipoReal = TipoTokenTerminal.NUMERO;

    public NumEntero(int val) {
        this.valor = val;
    }

    public Object getValorReal() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getIdentificador() {
        return super.getIdentificador();
    }

    public TipoTokenTerminal getTipoReal() {
        return this.tipoReal;
    }


}
