package automatas.meraki.analisisSemantico.Tipos;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class CaracterTipo implements Tipo {
    private static String identificador = "CARACTER";

    public String getIdentificador() {
        return this.identificador;
    }

    public String getValorR() {
        return "T";
    }

}
