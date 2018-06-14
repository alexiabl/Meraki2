package automatas.meraki;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/11/18.
 */
public class TablaSimbolos {

    //la idea es cargar la tabla de simbolos por contexto.

    private int idContexto;
    private List<Simbolo> tabla;

    public TablaSimbolos() {

    }

    public int getIdContexto() {
        return idContexto;
    }

    public void setIdContexto(int idContexto) {
        this.idContexto = idContexto;
    }

    public List<Simbolo> getTabla() {
        return tabla;
    }

    public void setTabla(List<Simbolo> tabla) {
        this.tabla = tabla;
    }

    public void agregarSimbolo(Simbolo s) {
        this.tabla.add(s);
    }
}
