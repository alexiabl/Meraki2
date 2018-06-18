package automatas.meraki.analisisSemantico.Reglas;

import automatas.meraki.analisisSemantico.Item;
import automatas.meraki.analisisSemantico.Token;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public interface Regla extends Item {


    public List<Item> getTokens();

    public void setTokens(List<Item> tokens);

    public String getIdentificador();

    public void setIdentificador(String nombre);
}
