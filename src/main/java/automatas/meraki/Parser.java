package automatas.meraki;

import automatas.meraki.analisisSemantico.Asignacion;
import automatas.meraki.analisisSemantico.DeclVar;
import automatas.meraki.analisisSemantico.Expresion;

import java.util.ArrayList;

/**
 * Created by alexiaborchgrevink on 6/13/18.
 */
public class Parser {

    private ArrayList<DeclVar> declaracionesVar;
    private ArrayList<Asignacion> asignaciones;
    private ArrayList<Expresion> expresiones;
    private Token token;

    public Parser() {
        this.declaracionesVar = new ArrayList<DeclVar>();
        this.asignaciones = new ArrayList<Asignacion>();
        this.expresiones = new ArrayList<Expresion>();
    }

    public void error(TipoTokenTerminal tipo) {
        System.out.println("ERROR: " + tipo.name());
        System.out.println("Linea: " + token.getNumLinea());
    }

    public ArrayList<DeclVar> getDeclaracionesVar(EstructuraArbol estructuraArbol) {
        return null;
    }

}
