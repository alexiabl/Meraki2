package automatas.meraki.analisisSemantico;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class IndicacionList {

    private List<Indicacion> indicaciones;

    public IndicacionList() {
        indicaciones = new LinkedList<Indicacion>();
    }

    public List<Indicacion> getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(List<Indicacion> indicaciones) {
        this.indicaciones = indicaciones;
    }
}
