package automatas.meraki.analisisSemantico;

import automatas.meraki.analisisSemantico.Tipos.Tipo;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class DeclVar {

    private Tipo tipo;
    private String identificador;

    public DeclVar(Tipo tipo, String id) {
        this.tipo = tipo;
        this.identificador = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
