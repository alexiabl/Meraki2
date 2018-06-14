package automatas.meraki.analisisSemantico;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class DeclaracionList {

    private List<DeclVar> declaraciones;

    public DeclaracionList() {
        declaraciones = new LinkedList<DeclVar>();
    }

    public List<DeclVar> getDeclaraciones() {
        return declaraciones;
    }

    public void setDeclaraciones(List<DeclVar> declaraciones) {
        this.declaraciones = declaraciones;
    }
}
