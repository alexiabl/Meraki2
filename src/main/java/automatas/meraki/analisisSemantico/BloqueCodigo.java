package automatas.meraki.analisisSemantico;

import automatas.meraki.analisisSemantico.Reglas.Regla;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class BloqueCodigo extends Regla {

    private String identificador;
    private Expresion valor;
    private List<Token> tokens;

    public BloqueCodigo(String id, List<Token> tokens) {
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
}
