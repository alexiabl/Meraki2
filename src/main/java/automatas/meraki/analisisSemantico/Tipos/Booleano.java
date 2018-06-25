package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Booleano extends Tipo {

    public boolean valor;
    private TipoTokenTerminal tipoReal = TipoTokenTerminal.TIPOBOOL;

    public Booleano(boolean val) {
        this.valor = val;
    }

    public Object getValorReal() {
        return this.valor;
    }

    public String getIdentificador() {
        return super.getIdentificador();
    }

}
