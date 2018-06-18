package automatas.meraki.analisisSemantico;

import automatas.meraki.analisisSemantico.Tipos.Tipo;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class Token {
    private TipoTokenTerminal tipoToken;
    private int numLinea;
    private int numLineaFinal;
    private int scope;
    private Tipo valor;
    private List<Token> lista;


    public Token(TipoTokenTerminal tipoTokenTerminal, int numLinea, Tipo valor) {
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

    public int getNumLineaFinal() {
        return this.numLineaFinal;
    }

    public void setNumLineaFinal(int numLinea) {
        this.numLineaFinal = numLinea;
    }

    public int getScope() {
        return this.scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getValor() {
        return this.valor.getIdentificador();
    }

    public String getValorReal() {  return this.valor.getValorR(); }

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
