package automatas.meraki;

//import automatas.meraki.analisisSemantico.*;
import automatas.meraki.analisisSemantico.Comparaciones.*;
import automatas.meraki.analisisSemantico.Item;
import automatas.meraki.analisisSemantico.Operaciones.*;
import automatas.meraki.analisisSemantico.Reglas.*;
import automatas.meraki.analisisSemantico.TipoTokenTerminal;
import automatas.meraki.analisisSemantico.Tipos.*;
import automatas.meraki.analisisSemantico.Token;
import automatas.meraki.analisisSemantico.analizadorSemantico;


import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        //Inicio Funcion
        Item tok1 = new Token(TipoTokenTerminal.TIPONUM, 1, new NumeroTipo()); //TKF
        Item tok2 = new Token(TipoTokenTerminal.N_FUNC, 1, new Texto("fibonacci")); //TKG
        Token tok3 = new Token(TipoTokenTerminal.PI, 1, new Car('(')); //TKF
        Regla regla1 = new Parametros("Parametros"); //TKF
        //Inicio Llamado
        Token tok4 = new Token(TipoTokenTerminal.TIPONUM, 1, new NumeroTipo());
        Token tok5 = new Token(TipoTokenTerminal.N_VAR, 1, new Variable("n"));
        List<Item> tokensReglaParametros = new LinkedList<Item>();
        tokensReglaParametros.add(tok4);
        tokensReglaParametros.add(tok5);
        regla1.setTokens(tokensReglaParametros);
        Token tok6 = new Token(TipoTokenTerminal.PF, 1, new Car(')'));  //TKF
        Token tok7 = new Token(TipoTokenTerminal.LLAVEI, 1, new Car('{')); //TKF

       //Inicio Si
        Regla regla2 = new Si("Si");
        Token tok8 =  new Token(TipoTokenTerminal.SI,2, new Texto("Si"));
        Token tok9 = new Token(TipoTokenTerminal.LLAVEI, 2, new Car('{'));
        //Inicio Condicion
        Regla condicion = new Condicion("Condicion");
                //Condicion1
        Regla condicion1 =  new Igual("Igual");
        Token tok31 = new Token(TipoTokenTerminal.N_VAR, 2, new Variable("n"));
        Token tok28 = new Token(TipoTokenTerminal.NUMERO,2,new NumEntero(0));
        List<Item> tokensReglaCondicion1 = new LinkedList<Item>();
        tokensReglaCondicion1.add(tok31);
        tokensReglaCondicion1.add(tok28);
        condicion1.setTokens(tokensReglaCondicion1);
            //Condicion2
        Regla condicion2 =  new Igual("Igual");
        Token tok29 = new Token(TipoTokenTerminal.N_VAR, 2, new Variable("n"));
        Token tok30 = new Token(TipoTokenTerminal.NUMERO,2,new NumEntero(1));
        List<Item> tokensReglaCondicion2 = new LinkedList<Item>();
        tokensReglaCondicion2.add(tok29);
        tokensReglaCondicion2.add(tok30);
        condicion2.setTokens(tokensReglaCondicion2);
            //Llenar condicion
        Token tok32 = new Token(TipoTokenTerminal.O,2,new Car('O'));
        List<Item> tokensReglaCondicion = new LinkedList<Item>();
        tokensReglaCondicion.add(condicion1);
        tokensReglaCondicion.add(tok32);
        tokensReglaCondicion.add(condicion2);
        condicion.setTokens(tokensReglaCondicion);


        //Inicio Devuelva
        Regla regla3 = new Devuelva("Devuelva");
        Token tok10 =  new Token(TipoTokenTerminal.DEVUELVA,3, 3,new Texto("Devuelva"));
        Token tok11 = new Token(TipoTokenTerminal.N_VAR, 3, new Variable("n"));
        List<Item> tokensReglaDevuelva1 = new LinkedList<Item>();
        tokensReglaDevuelva1.add(tok10);
        tokensReglaDevuelva1.add(tok11);
        regla3.setTokens(tokensReglaDevuelva1);

        //Llenar Si
        Token tok12 = new Token(TipoTokenTerminal.LLAVEF, 4, new Car('}'));
        List<Item> tokensReglaSi1 = new LinkedList<Item>();
        tokensReglaSi1.add(tok8);
        tokensReglaSi1.add(tok9);
        tokensReglaSi1.add(condicion);
        tokensReglaSi1.add(regla3);
        tokensReglaSi1.add(tok12);
        regla2.setTokens(tokensReglaSi1);       //TKF


        //Inicio sino
        Regla regla4 = new Sino("Sino");
        List<Item> tokensReglaSino = new LinkedList<Item>();
        Token tok13 =  new Token(TipoTokenTerminal.SINO,5, new Texto("Sino"));
        Token tok14 = new Token(TipoTokenTerminal.LLAVEI, 5, new Car('{'));
        tokensReglaSino.add(tok13);
        tokensReglaSino.add(tok14);

        //Inicio asignacion1 dentro de sino
        List<Item> tokensAsignacion = new LinkedList<Item>();
        Item tok15 = new Token(TipoTokenTerminal.TIPONUM, 6, new NumeroTipo());
        Item tok16 = new Token(TipoTokenTerminal.N_VAR, 6, new Variable("a"));
        Item tok17 = new Token(TipoTokenTerminal.SIGUAL, 6, new Car('='));
        tokensAsignacion.add(tok15);
        tokensAsignacion.add(tok16);
        tokensAsignacion.add(tok17);
        Regla asignacion1 = new Asignacion("Asignacion");
        asignacion1.setTokens(tokensAsignacion);
        Regla regla5 = new OperacionResta("OperacionResta");
        Item tokRegla1 = new Token(TipoTokenTerminal.N_VAR, 6, new Texto("n"));
        Item tokRegla2 = new Token(TipoTokenTerminal.NUMERO, 6, new NumEntero(2));
        List<Item> tokensReglaOperacionS = new LinkedList<Item>();
        tokensReglaOperacionS.add(tokRegla1);
        tokensReglaOperacionS.add(tokRegla2);
        regla5.setTokens(tokensReglaOperacionS);
        tokensAsignacion.add(regla5);


        //Inicio asignacion2 dentro de sino
        Item tok18 = new Token(TipoTokenTerminal.TIPONUM, 7, new NumeroTipo());
        Item tok19 = new Token(TipoTokenTerminal.N_VAR, 7, new Variable("b"));
        Item tok20 = new Token(TipoTokenTerminal.SIGUAL, 7, new Car('='));
        Regla regla6 = new OperacionResta("OperacionResta");
        Item tokRegla3 = new Token(TipoTokenTerminal.N_VAR, 7, new Variable("n"));
        Item tokRegla4 = new Token(TipoTokenTerminal.NUMERO, 7, new NumEntero(1));
        List<Item> tokensReglaOperacionR = new LinkedList<Item>();
        tokensReglaOperacionR.add(tokRegla3);
        tokensReglaOperacionR.add(tokRegla4);
        regla6.setTokens(tokensReglaOperacionR);

        List<Item> tokensAsignacion2 = new LinkedList<Item>();
        tokensAsignacion2.add(tok18);
        tokensAsignacion2.add(tok19);
        tokensAsignacion2.add(tok20);
        tokensAsignacion2.add(regla6);
        Regla asignacion2 = new Asignacion("Asignacion");
        asignacion2.setTokens(tokensAsignacion2);

        //Inicio asignacion3 dentro de sino
        Item tok21 = new Token(TipoTokenTerminal.TIPONUM, 8, new NumeroTipo());
        Item tok22 = new Token(TipoTokenTerminal.N_VAR, 8, new Variable("r"));
        Item tok23 = new Token(TipoTokenTerminal.SIGUAL, 8, new Car('='));
        //Inicio suma de asignacion
        Regla regla7 = new OperacionSuma("OperacionSuma");

        Regla regla8 = new Llamado("Llamado");
        Item tokRegla5 = new Token(TipoTokenTerminal.N_FUNC, 8, new Texto("fibonacci"));
        Item tokRegla6 = new Token(TipoTokenTerminal.TIPONUM, 8, new Texto("a"));
        List<Item> tokensReglaLlamado1 = new LinkedList<Item>();
        tokensReglaLlamado1.add(tokRegla5);
        tokensReglaLlamado1.add(tokRegla6);
        regla8.setTokens(tokensReglaLlamado1);

        Regla regla9 = new Llamado("Llamado");
        Item tokRegla7 = new Token(TipoTokenTerminal.N_FUNC, 8, new Texto("fibonacci"));
        Item tokRegla8 = new Token(TipoTokenTerminal.TIPONUM, 8, new Texto("b"));
        List<Item> tokensReglaLlamado2 = new LinkedList<Item>();
        tokensReglaLlamado2.add(tokRegla7);
        tokensReglaLlamado2.add(tokRegla8);
        regla9.setTokens(tokensReglaLlamado2);
        //llenados uma
        List<Item> tokensSuma = new LinkedList<Item>();
        tokensSuma.add(regla8);
        tokensSuma.add(regla9);
        regla7.setTokens(tokensSuma);

        //Llenado asignacion
        List<Item> tokensAsignacion3 = new LinkedList<Item>();
        tokensAsignacion3.add(tok21);
        tokensAsignacion3.add(tok22);
        tokensAsignacion3.add(tok23);
        tokensAsignacion3.add(regla7);
        Regla asignacion3 = new Asignacion("Asignacion");
        asignacion3.setTokens(tokensAsignacion3);

        //Inicio Devuelva en Sino
        Regla regla11 = new Devuelva("Devuelva");
        Token tok26 =  new Token(TipoTokenTerminal.DEVUELVA,9, new Texto("Devuelva"));
        Token tok27 = new Token(TipoTokenTerminal.N_VAR, 9, new Variable("r"));
        List<Item> tokensReglaDevuelva2 = new LinkedList<Item>();
        tokensReglaDevuelva2.add(tok26);
        tokensReglaDevuelva2.add(tok27);
        regla11.setTokens(tokensReglaDevuelva2);

        //Llena sino

        tokensReglaSino.add(asignacion1);
        tokensReglaSino.add(asignacion2);
        tokensReglaSino.add(asignacion3);
        tokensReglaSino.add(regla11);
        Token tok24 = new Token(TipoTokenTerminal.LLAVEF, 10, new Car('}'));
        tokensReglaSino.add(tok24);
        regla4.setTokens(tokensReglaSino);          //TKF

        //

        Token tok25 = new Token(TipoTokenTerminal.LLAVEF, 11, new Car('}')); //tkf
        Regla funcion = new Funcion("Funcion fibonacci");
        List<Item> tokensFuncion = new LinkedList<Item>();
        tokensFuncion.add(tok1);
        tokensFuncion.add(tok2);
        tokensFuncion.add(tok3);
        tokensFuncion.add(regla1);
        tokensFuncion.add(tok6);
        tokensFuncion.add(tok7);
        tokensFuncion.add(regla2);
        tokensFuncion.add(regla4);
        tokensFuncion.add(tok25);
        funcion.setTokens(tokensFuncion);

        ((Funcion) funcion).setParam(regla1.getTokens());
        ((Funcion) funcion).setDev(regla11.getTokens());
        //Inicio main
        Token tok35 = new Token(TipoTokenTerminal.MAIN,12,new Texto("main"));
        Token tok36 = new Token(TipoTokenTerminal.PI, 12, new Car('('));
        Token tok37 = new Token(TipoTokenTerminal.PF, 12, new Car(')'));
        Token tok38 = new Token(TipoTokenTerminal.LLAVEI, 12, new Car('{'));
        Token tok39 = new Token(TipoTokenTerminal.LLAVEF, 14, new Car('}'));
            //Llamado
        Regla llamado = new Llamado("Llamado");
        Item tokRegla14 = new Token(TipoTokenTerminal.N_FUNC, 13, new Texto("fibonacci"));
        Item tokRegla15 = new Token(TipoTokenTerminal.NUMERO, 13, new NumEntero(5));
        List<Item> tokensReglaLlamado3 = new LinkedList<Item>();
        tokensReglaLlamado3.add(tokRegla14);
        tokensReglaLlamado3.add(tokRegla15);
        llamado.setTokens(tokensReglaLlamado3);

        Regla main = new Main("Main");
        List<Item> tokensReglaMain = new LinkedList<Item>();
        tokensReglaMain.add(tok35);
        tokensReglaMain.add(tok36);
        tokensReglaMain.add(tok37);
        tokensReglaMain.add(tok38);
        tokensReglaMain.add(llamado);
        tokensReglaMain.add(tok39);
        main.setTokens(tokensReglaMain);

        Regla meraki = new Meraki("Meraki");
        List<Item> tokensReglaMeraki = new LinkedList<Item>();
        tokensReglaMeraki.add(funcion);
        tokensReglaMeraki.add(main);
        meraki.setTokens(tokensReglaMeraki);

        EstructuraArbol arbolSemantico = new EstructuraArbol();

        arbolSemantico.insertItem2(meraki,0);
//        arbolSemantico.imprimirArbol();
        arbolSemantico.imprimirTablaSimbolos();
        arbolSemantico.imprimirTablaSimbolosFunciones();

        Token tok40 = new Token(TipoTokenTerminal.LLAVEF, 11, new Car('.')); //tkf
        analizadorSemantico semantico = new analizadorSemantico(arbolSemantico);
        semantico.revisarDevoluciones(arbolSemantico.getFunciones());


        /*
        Item tokRegla7 = new Token(TipoTokenTerminal.N_VAR, 6, new Texto("n"));
        Item tokRegla8 = new Token(TipoTokenTerminal.NUMERO, 6, new NumEntero(1));
        List<Item> tokensReglaOperacionR = new LinkedList<Item>();
        tokensReglaOperacionR.add(tokRegla3);
        tokensReglaOperacionR.add(tokRegla4);
        regla6.setTokens(tokensReglaOperacionR);

        List<Item> tokensAsignacion2 = new LinkedList<Item>();
        tokensAsignacion.add(tok18);
        tokensAsignacion.add(tok19);
        tokensAsignacion.add(tok20);
        tokensAsignacion.add(regla6);
        Regla asignacion2 = new Asignacion("Asignacion");
        asignacion2.setTokens(tokensAsignacion2);*/


        /*
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

        arbolSemantico.insertItem2(asignacion, 0);


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

        */
    }
}
