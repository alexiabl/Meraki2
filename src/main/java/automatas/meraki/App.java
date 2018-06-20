package automatas.meraki;

import automatas.meraki.analisisSemantico.*;
import automatas.meraki.analisisSemantico.Operaciones.OperacionDivision;
import automatas.meraki.analisisSemantico.Reglas.Asignacion;
import automatas.meraki.analisisSemantico.Reglas.Funcion;
import automatas.meraki.analisisSemantico.Reglas.Regla;
import automatas.meraki.analisisSemantico.Tipos.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Item tok1 = new Token(TipoTokenTerminal.TIPONUM, 1, new NumeroTipo());
        Item tok2 = new Token(TipoTokenTerminal.N_VAR, 1, new Texto("n"));
        Item tok3 = new Token(TipoTokenTerminal.SIGUAL, 1, new Car('='));
        //Item tok4 = new Token(TipoTokenTerminal.NUMERO, 1, new NumEntero(5));

        Regla regla1 = new OperacionDivision("OperacionDivision");
        Item tokRegla1 = new Token(TipoTokenTerminal.NUMERO, 1, new NumEntero(5));
        Item tokRegla2 = new Token(TipoTokenTerminal.NUMERO, 1, new NumEntero(6));
        List<Item> tokensReglaOperaciones = new LinkedList<Item>();
        tokensReglaOperaciones.add(tokRegla1);
        tokensReglaOperaciones.add(tokRegla2);
        regla1.setTokens(tokensReglaOperaciones);

        List<Item> tokensAsignacion = new LinkedList<Item>();
        tokensAsignacion.add(tok1);
        tokensAsignacion.add(tok2);
        tokensAsignacion.add(tok3);
        tokensAsignacion.add(regla1);
        Regla asignacion = new Asignacion("Asignacion");
        asignacion.setTokens(tokensAsignacion);


        EstructuraArbol arbolSemantico = new EstructuraArbol();

        arbolSemantico.insertItem2(asignacion,0);

        Token tok5 = new Token(TipoTokenTerminal.TIPONUM, 2, new NumeroTipo());
        Token tok6 = new Token(TipoTokenTerminal.N_FUNC, 2, new Texto("galleta"));
        Token tok7 = new Token(TipoTokenTerminal.PI, 2, new Car('('));
        Token tok9 = new Token(TipoTokenTerminal.TIPONUM, 2, new NumeroTipo());
        Token tok10 = new Token(TipoTokenTerminal.N_VAR, 2, new Texto("param1"));
        Token tok8 = new Token(TipoTokenTerminal.PF, 2, new Car(')'));
        Token tok11 = new Token(TipoTokenTerminal.LLAVEI, 2, new Car('{'));


        Token tok12 = new Token(TipoTokenTerminal.TIPOTEXTO, 3, new TextoTipo());
        Token tok13 = new Token(TipoTokenTerminal.N_VAR, 3, new Texto("varTipo"));
        Token tok14 = new Token(TipoTokenTerminal.TEXTO, 3, new Texto("hola soy texto"));
        Token tok15 = new Token(TipoTokenTerminal.DEVUELVA, 4, new Texto("devuelva"));
        Token tok16 = new Token(TipoTokenTerminal.N_VAR, 4, new Texto("devuelva"));
        Token tok17 = new Token(TipoTokenTerminal.LLAVEF, 5, new Car('}'));

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

        Regla funcion1 = new Funcion("Funcion");
      //  arbolSemantico.insertItem2(funcion1);

        arbolSemantico.imprimirArbol();
        arbolSemantico.imprimirTablas();


    }
}
