package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Car extends Tipo {

    public char valor;
    private TipoTokenTerminal tipoReal = TipoTokenTerminal.CARACTER;

    public Car(char val) {
        this.valor = val;
    }

    public Object getValorReal() {
        return valor;
    }

    public String getIdentificador() {
        return super.getIdentificador();
    }

}
