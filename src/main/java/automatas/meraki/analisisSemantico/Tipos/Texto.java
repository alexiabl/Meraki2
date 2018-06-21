package automatas.meraki.analisisSemantico.Tipos;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Texto extends TextoTipo {

    private String valor;

    public Texto(String val) {
        this.valor = val;
    }

    public String getValor() {
        return valor;
    }

    public String getIdentificador() {
        return super.getIdentificador();
    }

    public String getValorR() {
        return this.valor;
    }
}
