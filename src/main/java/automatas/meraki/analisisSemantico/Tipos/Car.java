package automatas.meraki.analisisSemantico.Tipos;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Car extends CaracterTipo {

    private char valor;

    public Car(char val) {
        this.valor = val;
    }

    public char getValor() {
        return valor;
    }

    public String getIdentificador() {
        return super.getIdentificador();
    }

    public String getValorR() {
        return "T";
    }
}
