package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class BooleanoTipo extends Tipo {
    private static String identificador = "booleano";

    public String getIdentificador() {
        return this.identificador;
    }

    public TipoTokenTerminal getTipoReal() {
        return TipoTokenTerminal.TIPOBOOL;
    }

}
