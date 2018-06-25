package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class CaracterTipo extends Tipo {
    private static String identificador = "CARACTER";

    public String getIdentificador() {
        return this.identificador;
    }

    public TipoTokenTerminal getTipoReal() {
        return TipoTokenTerminal.CARACTER;
    }

}
