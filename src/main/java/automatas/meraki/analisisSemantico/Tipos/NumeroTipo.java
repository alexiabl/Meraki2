package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class NumeroTipo extends Tipo {

    private static String identificador = "NUMERO";

    public NumeroTipo() {

    }

    public String getIdentificador() {
        return this.identificador;
    }

    public TipoTokenTerminal getTipoReal() {
        return TipoTokenTerminal.NUMERO;
    }
}
