package automatas.meraki.analisisSemantico.Tipos;

import automatas.meraki.analisisSemantico.TipoTokenTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class TextoTipo extends Tipo {
    private static String identificador = "TEXTO";

    public String getIdentificador() {
        return this.identificador;
    }

    public TipoTokenTerminal getTipoReal() {
        return TipoTokenTerminal.TEXTO;
    }

    public Object getValor() {
        return "TextoTipo";
    }


}
