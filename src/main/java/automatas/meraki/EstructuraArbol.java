package automatas.meraki;

import automatas.meraki.analisisSemantico.*;
import automatas.meraki.arbol.Node;
import automatas.meraki.arbol.PointerTree;
import automatas.meraki.arbol.PointerTreeNode;
import automatas.meraki.arbol.Tree;
import com.sun.jmx.remote.internal.ArrayQueue;
import automatas.meraki.analisisSemantico.Tipos.*;

import java.util.LinkedList;
import java.util.List;

public class EstructuraArbol {

    private PointerTree<Regla> arbol;
    private Node<Regla> nodoActual;
    private int scopeCounter;
    private int niveles;
    private TablaSimbolos tablaSimbolos;
    private TablaSimbolos tablaFunciones;
    private List<Regla> asignaciones;
    private List<Regla> funciones;
    private List<Regla> declaraciones;


    public EstructuraArbol() {
        this.scopeCounter = 1;
        Regla regla = new BloqueCodigo("Meraki", new LinkedList<Token>());
        this.arbol = new PointerTree<Regla>(regla);
        this.nodoActual = this.arbol.getRoot();
        this.niveles = 1;
        this.tablaSimbolos = new TablaSimbolos();
        this.tablaFunciones = new TablaSimbolos();
        this.asignaciones = new LinkedList<Regla>();
        this.funciones = new LinkedList<Regla>();
        this.declaraciones = new LinkedList<Regla>();

    }

    public Tree<Regla> getArbol() {
        return arbol;
    }

    public void setArbol(PointerTree<Regla> arbol) {
        this.arbol = arbol;
    }

    public void insertItem(Regla regla) {
        boolean nuevoNivel = true;
        Regla reglaActual = regla;
        Node<Regla> nodoHijo = this.nodoActual;
        String tipoRegla = regla.getIdentificador();
        if (tipoRegla.equals("Asignacion")) {
            //for (Token token : regla.getTokens()) {
                //if (token.getTipoToken().equals(TipoTokenTerminal.N_VAR)) {
                    Token toktemp = regla.getTokens().get(1);
                    toktemp.setTipoToken(regla.getTokens().get(0).getTipoToken());
                   // Token tok1 = new Token(regla.getTokens().get(0).getTipoToken(),regla.getTokens().get(0).getNumLinea(),new Texto("Temp"));
                    insertarATabla(toktemp);
                        //break;
               // }
           // }
            this.asignaciones.add(regla);
        }
        if (tipoRegla.equals("Declaracion")) {
         //   for (Token token : regla.getTokens()) {
               // if (token.getTipoToken().equals(TipoTokenTerminal.N_VAR)) {
            Token toktemp = regla.getTokens().get(1);
            toktemp.setTipoToken(regla.getTokens().get(0).getTipoToken());
                    insertarATabla(toktemp);
                //    break;
               // }
            //}
            this.declaraciones.add(regla);
        }
        if (tipoRegla.equals("Funcion")) {
           // for (Token token : regla.getTokens()) {
            //    if (token.getTipoToken().equals(TipoTokenTerminal.N_FUNC)) {
                    Token toktemp = regla.getTokens().get(1);
                    toktemp.setTipoToken(regla.getTokens().get(0).getTipoToken());
                    toktemp.setNumLineaFinal(regla.getTokens().get(regla.getTokens().size()-1).getNumLinea());

                   // System.out.println(regla.getTokens().size()-1);
                    //System.out.println(regla.getTokens().get(regla.getTokens().size()-1).getNumLinea());
                    insertarATabla(toktemp);

              //  } else if (token.getTipoToken().equals(TipoTokenTerminal.N_VAR)) {

            //    }
          //  }
            this.funciones.add(regla);
        }
        for (int i = 0; i < regla.getTokens().size(); i++) {
            Token tok = regla.getTokens().get(i);
            Node<Regla> nodo = this.nodoActual;
            if (tok.getTipoToken().equals(TipoTokenTerminal.LLAVEI)) {
                this.scopeCounter++;
                tok.setScope(this.scopeCounter);
                List<Token> nextTokens = new LinkedList<Token>();
                for (int j = i; j < regla.getTokens().size(); j++) {
                    regla.getTokens().get(j).setScope(this.scopeCounter);
                    nextTokens.add(regla.getTokens().get(j));
                }
                Regla bloque = new BloqueCodigo("BloqueCodigo", nextTokens);
                reglaActual = bloque;
                Node<Regla> nuevoNodo = new PointerTreeNode<Regla>(bloque, nodoHijo);
                nodoHijo.addChild(nuevoNodo);
                nodo = nuevoNodo;
                this.nodoActual = nodo;
                this.niveles++;
            }
            if (nuevoNivel) {
                Node<Regla> nodoRegla = new PointerTreeNode<Regla>(reglaActual, this.nodoActual);
                this.nodoActual.addChild(nodoRegla);
                nodoHijo = nodoRegla;
                nuevoNivel = false;
            } else if (tok.getTipoToken().equals(TipoTokenTerminal.LLAVEF)) {
                for (int k = 0; k < this.niveles; k++) {
                    this.nodoActual = this.nodoActual.getParent();
                }
            }
        }
    }

    public void insertarATabla(Token tok) {
        this.tablaSimbolos.getTabla().add(tok);
    }


    public void imprimirArbol() {
        List<Node<Regla>> imprimirArbol = getInDepthTraversal(this.arbol);
        for (int i = 0; i < imprimirArbol.size(); i++) {
            System.out.println("Regla: " + imprimirArbol.get(i).getLabel().getIdentificador());
            Node<Regla> current = imprimirArbol.get(i);
            if (current.getChildren().size() > 0) {
                for (int j = 0; j < current.getChildren().size(); j++) {
                    System.out.println("Hijo: " + current.getChildren().get(j).getLabel().getIdentificador());
                }
            }
        }
    }

    public void imprimirTablas() {
        List<Token> tablaAsig = this.tablaSimbolos.getTabla();
        System.out.println("Tabla de Simbolos:");
        for (int i = 0; i < tablaAsig.size(); i++) {                                                                      //OBTENER VALOR REAL
             if(tablaAsig.get(i).getNumLineaFinal()!= 0){
                System.out.println("Función Tipo: " + tablaAsig.get(i).getTipoToken() + " Valor: " + tablaAsig.get(i).getValorReal() + " Linea Inicial: " + tablaAsig.get(i).getNumLinea() + " Linea Final: " + tablaAsig.get(i).getNumLineaFinal()) ;
            }
            else{
                 System.out.println("Variable Tipo: " + tablaAsig.get(i).getTipoToken() + " Valor: " + tablaAsig.get(i).getValorReal() + " Linea: " + tablaAsig.get(i).getNumLinea());

             }

        }
    }


    public static <T> List<Node<T>> getLevelTraversal(Tree<T> tree) {
        ArrayQueue<T> q = new ArrayQueue<T>(tree.getRoot().getChildren().size());
        List<Node<T>> list = new LinkedList<Node<T>>();
        Node current = tree.getRoot();
        list.add(current);
        int cont = 0;
        while (tree.getRoot().getChildren().size() > 0 && cont < tree.getRoot().getChildren().size()) {
            current = tree.getRoot().getChildAt(cont);
            list.add(current);
            cont++;
        }
        cont = 0;
        current = tree.getRoot().getChildAt(cont);
        while (current != null && cont < tree.getRoot().getChildren().size()) {
            current = tree.getRoot().getChildAt(cont);
            if (current.getChildren().size() > 0) {
                int size = current.getChildren().size();
                current = current.getChildAt(0);
                for (int i = 0; i < size; i++) {
                    list.add(current);
                    if (size > 1) {
                        current = current.getChildAt(i);
                    }
                }
            }
            cont++;
        }
        return list;
    }

    public static <T> List<Node<T>> getInDepthTraversal(Tree<T> tree) {
        List<Node<T>> list = new LinkedList<Node<T>>();
        Node current = tree.getRoot();
        list.add(current);
        int cont = 0;
        while (cont < tree.getRoot().getChildren().size()) {
            current = tree.getRoot().getChildAt(cont);
            list.add(current);
            if (current.getChildren().size() > 0) {
                int cont2 = 0;
                int size = current.getChildren().size();
                for (int i = 0; i < size; i++) {
                    current = current.getChildAt(i);
                    list.add(current);
                    if (size > 1) {
                        current = current.getChildAt(i);
                    }
                }
            }
            cont++;
        }
        return list;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    public List<Regla> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Regla> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public List<Regla> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Regla> funciones) {
        this.funciones = funciones;
    }

    public List<Regla> getDeclaraciones() {
        return declaraciones;
    }

    public void setDeclaraciones(List<Regla> declaraciones) {
        this.declaraciones = declaraciones;
    }
}
