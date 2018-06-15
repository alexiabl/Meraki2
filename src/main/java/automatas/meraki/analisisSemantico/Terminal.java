package automatas.meraki.analisisSemantico;

import automatas.meraki.analisisSemantico.Tipos.Tipo;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Terminal extends Token {

    private TipoTokenTerminal tipoToken;
    private int numLinea;
    private int scope;
    private Tipo valor;

    public Terminal(TipoTokenTerminal tipoTokenTerminal, int numLinea, Tipo valor) {
        super(tipoTokenTerminal, numLinea, valor);
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

    public Tipo getValor() {
        return this.getValor();
    }

    public void setValor(Tipo valor) {
        this.valor = valor;
    }

    public TipoTokenTerminal getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoTokenTerminal tipoToken) {
        this.tipoToken = tipoToken;
    }
}
