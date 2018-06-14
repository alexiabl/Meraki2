package automatas.meraki.analisisSemantico.Comparaciones;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class ComparacionList {

    private List<Comparacion> comparaciones;

    public ComparacionList() {
        comparaciones = new LinkedList<Comparacion>();
    }

    public List<Comparacion> getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones(List<Comparacion> comparaciones) {
        this.comparaciones = comparaciones;
    }
}
