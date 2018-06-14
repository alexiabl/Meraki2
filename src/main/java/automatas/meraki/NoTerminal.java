package automatas.meraki;

import automatas.TipoTokenNoTerminal;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class NoTerminal implements Token {

    private TipoTokenNoTerminal tipoToken;
    private int numLinea;
    private int scope;
    private String valor;

    public NoTerminal(TipoTokenNoTerminal tipoTokenTerminal, int numLinea, String valor) {
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
        return this.scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getValor() {
        return this.getValor();
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoTokenNoTerminal getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenNoTerminal tipoToken) {
        this.tipoToken = tipoToken;
    }
}
