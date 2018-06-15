package automatas.meraki.analisisSemantico.Tipos;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Booleano extends BooleanoTipo {

    private boolean valor;

    public Booleano(boolean val) {
        this.valor = val;
    }

    public boolean getValor() {
        return valor;
    }

    public String getIdentificador() {
        return super.getIdentificador();
    }

}
