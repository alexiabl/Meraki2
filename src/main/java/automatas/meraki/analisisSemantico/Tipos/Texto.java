package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Texto extends Tipo {

    public String valor;
    private TipoTokenTerminal tipoReal = TipoTokenTerminal.TEXTO;

    public Texto(String val) {
        this.valor = val;
    }

    public String getValorReal() {
        return this.valor;
    }

    public String getIdentificador() {
        return super.getIdentificador();
    }


}
