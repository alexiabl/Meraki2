package automatas.meraki.analisisSemantico;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class Asignacion {

    private String identificador;
    private Expresion valor;

    public Asignacion(String id, Expresion valor) {
        this.identificador = id;
        this.valor = valor;
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
