package automatas.meraki;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/11/18.
 */
public class TablaSimbolos {

    //la idea es cargar la tabla de simbolos por contexto.

    private int idContexto;
    private List<Token> tabla;

    public TablaSimbolos() {
        this.tabla = new LinkedList<Token>();
    }

    public int getIdContexto() {
        return idContexto;
    }

    public void setIdContexto(int idContexto) {
        this.idContexto = idContexto;
    }

    public List<Token> getTabla() {
        return tabla;
    }

    public void setTabla(List<Token> tabla) {
        this.tabla = tabla;
    }

    public void agregarSimbolo(Token s) {
        this.tabla.add(s);
    }
}
