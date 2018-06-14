package automatas.meraki;

import automatas.Terminal;
import automatas.TipoTokenNoTerminal;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Token tok1 = new Terminal(TipoTokenTerminal.TIPONUM, 1, "numero");
        Token tok2 = new Terminal(TipoTokenTerminal.N_VAR, 1, "n");
        Token tok3 = new Terminal(TipoTokenTerminal.SIGUAL, 1, "=");
        Token tok4 = new Terminal(TipoTokenTerminal.NUMERO, 1, "5");
        List<Token> tokensAsignacion = new LinkedList<Token>();
        tokensAsignacion.add(tok1);
        tokensAsignacion.add(tok2);
        tokensAsignacion.add(tok3);
        tokensAsignacion.add(tok4);
        Regla asignacion = new Regla("Asignacion", tokensAsignacion);

        EstructuraArbol arbolSemantico = new EstructuraArbol();

        arbolSemantico.insertItem(asignacion);


        Token tok5 = new Terminal(TipoTokenTerminal.TIPONUM, 2, "numero");
        Token tok6 = new Terminal(TipoTokenTerminal.N_VAR, 2, "galleta");
        Token tok7 = new Terminal(TipoTokenTerminal.PI, 2, "(");
        Token tok8 = new Terminal(TipoTokenTerminal.PF, 2, ")");
        Token tok9 = new Terminal(TipoTokenTerminal.TIPONUM, 2, "numero");
        Token tok10 = new Terminal(TipoTokenTerminal.N_VAR, 2, "param1");
        Token tok11 = new Terminal(TipoTokenTerminal.LLAVEI, 2, "{");

        Token tok12 = new Terminal(TipoTokenTerminal.TIPOTEXTO, 3, "texto");
        Token tok13 = new Terminal(TipoTokenTerminal.N_VAR, 3, "varTexto");
        Token tok14 = new Terminal(TipoTokenTerminal.TEXTO, 3, "hola soy texto");
        Token tok15 = new Terminal(TipoTokenTerminal.DEVUELVA, 4, "devuelva");
        Token tok16 = new Terminal(TipoTokenTerminal.N_VAR, 4, "varTexto");
        Token tok17 = new Terminal(TipoTokenTerminal.LLAVEF, 5, "}");

        List<Token> tokens = new LinkedList<Token>();


        tokens.add(tok5);
        tokens.add(tok6);
        tokens.add(tok7);
        tokens.add(tok8);
        tokens.add(tok9);
        tokens.add(tok10);
        tokens.add(tok11);
        tokens.add(tok12);
        tokens.add(tok13);
        tokens.add(tok14);
        tokens.add(tok15);
        tokens.add(tok16);
        tokens.add(tok17);

        Regla funcion1 = new Regla("Funcion", tokens);
        arbolSemantico.insertItem(funcion1);

        arbolSemantico.imprimirArbol();
        arbolSemantico.imprimirTablas();


    }
}