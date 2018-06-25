package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public abstract class Tipo {


    public String getIdentificador() {
        return "Tipo";
    }

    public TipoTokenTerminal getTipoReal() {
        return null;
    }

    public Object getValorReal() {
        return "ValorTipo";
    }

}
