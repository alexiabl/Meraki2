package automatas.meraki.analisisSemantico.Comparaciones;

import automatas.meraki.analisisSemantico.Expresion;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public interface Comparacion extends Expresion {

    public Expresion getLadoIzq();

    public Expresion getLadoDer();

    public void setLadoIzq(Expresion ladoIzq);

    public void setLadoDer(Expresion ladoDer);
}
