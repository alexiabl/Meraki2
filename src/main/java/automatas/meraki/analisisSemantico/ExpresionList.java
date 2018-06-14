package automatas.meraki.analisisSemantico;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class ExpresionList {

    private List<Expresion> expresiones;

    public ExpresionList() {
        this.expresiones = new LinkedList<Expresion>();
    }

    public List<Expresion> getExpresiones() {
        return expresiones;
    }

    public void setExpresiones(List<Expresion> expresiones) {
        this.expresiones = expresiones;
    }
}
