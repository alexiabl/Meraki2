package automatas.meraki.analisisSemantico;

import automatas.meraki.analisisSemantico.Reglas.Regla;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/11/18.
 */
public class TablaSimbolos {

    private List<Token> tabla;

    public TablaSimbolos() {
        this.tabla = new LinkedList<Token>();
    }

    public List<Token> getTabla() {
        return tabla;
    }

    public void setTabla(List<Token> tabla) {
        this.tabla = tabla;
    }

    public void insertarATabla(Token tok) {
        this.tabla.add(tok);
    }

    //public List<Token>
}
