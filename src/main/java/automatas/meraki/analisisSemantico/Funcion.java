package automatas.meraki.analisisSemantico;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/14/18.
 */
public class Funcion extends Regla {

    private String identificador;
    private Expresion valor;
    private List<Token> tokens;

    public Funcion(String id, List<Token> tokens) {
        this.identificador = id;
        this.valor = valor;
        this.tokens = tokens;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Expresion getValor() {
        return valor;
    }

    public void setValor(Expresion valor) {
        this.valor = valor;
    }

    @Override
    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
