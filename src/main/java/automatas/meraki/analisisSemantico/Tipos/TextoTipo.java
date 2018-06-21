package automatas.meraki.analisisSemantico.Tipos;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class TextoTipo implements Tipo {
    private static String identificador = "TEXTO";

    public String getIdentificador() {
        return this.identificador;
    }

    public String getValorR() {
        return "Temp";
    }


}
