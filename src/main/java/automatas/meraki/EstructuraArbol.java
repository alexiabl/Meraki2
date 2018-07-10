package automatas.meraki;

import automatas.meraki.analisisSemantico.*;
import automatas.meraki.analisisSemantico.Operaciones.OperacionDivision;
import automatas.meraki.analisisSemantico.Operaciones.OperacionMultiplicacion;
import automatas.meraki.analisisSemantico.Operaciones.OperacionResta;
import automatas.meraki.analisisSemantico.Operaciones.OperacionSuma;
import automatas.meraki.analisisSemantico.Reglas.*;
import automatas.meraki.arbol.Node;
import automatas.meraki.arbol.PointerTree;
import automatas.meraki.arbol.PointerTreeNode;
import automatas.meraki.arbol.Tree;
import com.sun.jmx.remote.internal.ArrayQueue;
import automatas.meraki.analisisSemantico.analizadorSemantico;

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
    private analizadorSemantico analizadorSemantico;


    public EstructuraArbol() {
        this.scopeCounter = 1;
        Regla regla = new Meraki("Meraki");
        this.arbol = new PointerTree<Regla>(regla);
        this.nodoActual = this.arbol.getRoot();
        this.niveles = 1;
        this.tablaSimbolos = new TablaSimbolos();
        this.tablaFunciones = new TablaSimbolos();
        this.asignaciones = new LinkedList<Regla>();
        this.funciones = new LinkedList<Regla>();
        this.declaraciones = new LinkedList<Regla>();
        this.analizadorSemantico = new analizadorSemantico(this);

    }

    public Tree<Regla> getArbol() {
        return arbol;
    }

    public void setArbol(PointerTree<Regla> arbol) {
        this.arbol = arbol;
    }

    public void insertItem2(Regla regla, int niveles) {
        Node<Regla> nodoActual = this.nodoActual;
        Regla reglaNodo = new Asignacion(regla.getIdentificador());

        if (regla instanceof Asignacion) {
            Token tokenTipo = (Token) regla.getTokens().get(0);
            if (regla.getTokens().get(1) instanceof Token) {
                Token tokenVar = (Token) regla.getTokens().get(1);
                //this.analizadorSemantico.verificarTipos(tokenTipo.getTipoToken(),tokenVar.getTipoToken());
                Token tokenTabla = new Token(tokenTipo.getTipoToken(), tokenTipo.getNumLinea(), tokenVar.getValor());
                this.tablaSimbolos.insertarATabla(tokenTabla);
            }
            this.asignaciones.add(regla);
            //hay que revisar si lo que esta al otro lado de la asignacion es una regla (ej. operacion)

            //problemas para enviar tercer token y verificar el tipo
            // ejemplo numero n = 5; ocupo llegar a 5 para ver su tipo, que debe ser numero

        } else if (regla instanceof Declaracion) {
            this.declaraciones.add(regla);
        } else if (regla instanceof Funcion) {
            Token tokenTipo = (Token) regla.getTokens().get(0);
            Token fin = (Token)regla.getTokens().get(regla.getTokens().size()-1);
            tokenTipo.setNumLineaFinal(fin.getNumLinea());
            Token tokenVar = (Token) regla.getTokens().get(1);
            Token tokenTabla = new Token(tokenTipo.getTipoToken(), tokenTipo.getNumLinea(), tokenTipo.getNumLineaFinal(), tokenVar.getValor());
            this.tablaFunciones.insertarATabla(tokenTabla);
            this.funciones.add(regla);



        } else if (regla instanceof Parametros && regla != null) {
            Token tokenTipo = (Token) regla.getTokens().get(0);
            Token tokenVar = (Token) regla.getTokens().get(1);
            Token tokenTabla = new Token(tokenTipo.getTipoToken(), tokenTipo.getNumLinea(), tokenVar.getValor());
            this.tablaSimbolos.insertarATabla(tokenTabla);
        }

        Node<Regla> nodoAsignacion = new PointerTreeNode<Regla>(reglaNodo, this.nodoActual);
        this.nodoActual.addChild(nodoAsignacion); //Aqui esta agregando doble cuando hace el llamado recursivo
        // }
        for (int i = 0; i < regla.getTokens().size(); i++) {
            Item itemPrevio = null;
            if (i > 0) {
                itemPrevio = regla.getTokens().get(i - 1);
            }
            Item item = regla.getTokens().get(i);
            if (item instanceof Token) {
                //agregar token a lista de tokens de nueva regla asignacion
                reglaNodo.agregarATokens(item);

                //si el item previo fue una Regla, tengo que devolverme de nivel
                if (itemPrevio != null && itemPrevio instanceof Regla) {
                    System.out.println(("   " + ((Regla) itemPrevio).getIdentificador()));
                    for (int n = 0; n < niveles; n++) {
                        this.nodoActual = this.nodoActual.getParent();
                    }
                }
            } else if (item instanceof Regla) {
                //nuevo nivel
                Regla reglaHijo = (Regla) item;
                reglaHijo.setTokens(((Regla) item).getTokens());
                Node<Regla> nodoHijo = new PointerTreeNode<Regla>(reglaHijo, nodoAsignacion);
                //nodoAsignacion.addChild(nodoHijo);
                this.nodoActual = nodoAsignacion;
                niveles++;
                this.insertItem2(reglaHijo, niveles);
                niveles--;
            }
            System.out.println(regla.getIdentificador());
        }
    }

    public void insertarATabla(Token tok) {
        this.tablaSimbolos.getTabla().add(tok);
    }

    public TipoTokenTerminal buscarTipo(Token n)
    {
        TipoTokenTerminal buscado=null;
        List<Token> tablaAsig = this.tablaSimbolos.getTabla();
        int i = 0;
        while( i < tablaAsig.size() )  {
            if (tablaAsig.get(i).getNumLineaFinal() == 0) {
                if (tablaAsig.get(i).getValorReal() == n.getValorReal()) {
                    System.out.println("Variable Tipo: " + tablaAsig.get(i).getTipoToken());
                    buscado = tablaAsig.get(i).getTipoToken();
                }
            }
            i++;
        }
        return buscado;
    }

    public void imprimirArbol() {
        List<Node<Regla>> imprimirArbol = getLevelTraversal(this.arbol);
        for (int i = 0; i < imprimirArbol.size(); i++) {
            System.out.println("Regla: " + imprimirArbol.get(i).getLabel().getIdentificador());
            Node<Regla> current = imprimirArbol.get(i);
            if (current.getChildren().size() > 0) {
                for (int j = 0; j < current.getChildren().size(); j++) {
                    System.out.println("    Hijo: " + current.getChildren().get(j).getLabel().getIdentificador());
                }
            }
        }
    }

    public void imprimirTablaSimbolos() {
        List<Token> tablaAsig = this.tablaSimbolos.getTabla();
        System.out.println("Tabla de Simbolos:");
        for (int i = 0; i < tablaAsig.size(); i++) {                                                                      //OBTENER VALOR REAL de token
            if (tablaAsig.get(i).getNumLineaFinal() != 0) {
                System.out.println("Función Tipo: " + tablaAsig.get(i).getTipoToken() + " Valor: " + tablaAsig.get(i).getValor().getValorReal() + " Linea Inicial: " + tablaAsig.get(i).getNumLinea() + " Linea Final: " + tablaAsig.get(i).getNumLineaFinal());
            } else {
                System.out.println("Variable Tipo: " + tablaAsig.get(i).getTipoToken() + " Valor: " + tablaAsig.get(i).getValor().getValorReal() + " Linea: " + tablaAsig.get(i).getNumLinea());

            }
        }
    }

    public void imprimirTablaSimbolosFunciones() {
        List<Token> tablaFuncion = this.tablaFunciones.getTabla();
        System.out.println("Tabla de Funciones:");
        for (int i = 0; i < tablaFuncion.size(); i++) {
                System.out.println("Función Tipo: " + tablaFuncion.get(i).getTipoToken() +
                        " Nombre: " + tablaFuncion.get(i).getValorReal() + " Linea Inicial: "
                        + tablaFuncion.get(i).getNumLinea() + " Linea Final: " + tablaFuncion.get(i).getNumLineaFinal());
        }
    }


    public <T> List<Node<T>> getLevelTraversal(Tree<T> tree) {
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

    public <T> List<Node<T>> getInDepthTraversal(Tree<T> tree) {
        List<Node<T>> list = new LinkedList<Node<T>>();
        Node<T> current = tree.getRoot();
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
        return this.tablaSimbolos;
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
        return this.funciones;
    }

    public void setFunciones(List<Regla> funciones) {
        this.funciones = funciones;
    }

    public List<Regla> getDeclaraciones() {
        return this.declaraciones;
    }

    public void setDeclaraciones(List<Regla> declaraciones) {
        this.declaraciones = declaraciones;
    }
}
