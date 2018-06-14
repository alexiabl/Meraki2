package automatas;

import automatas.meraki.TipoTokenTerminal;
import automatas.meraki.Token;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Terminal implements Token {

    private TipoTokenTerminal tipoToken;
    private int numLinea;
    private int scope;
    private String valor;

    public Terminal(TipoTokenTerminal tipoTokenTerminal, int numLinea, String valor) {
        this.tipoToken = tipoTokenTerminal;
        this.numLinea = numLinea;
        this.valor = valor;
    }

    public Object getTipo() {
        return this.tipoToken;
    }

    public int getNumLinea() {
        return this.numLinea;
    }

    public void setNumLinea(int numLinea) {
        this.numLinea = numLinea;
    }

    public int getScope() {
        return this.getScope();
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
