package automatas.meraki;

import automatas.meraki.arbol.Node;
import automatas.meraki.arbol.PointerTree;
import automatas.meraki.arbol.PointerTreeNode;
import automatas.meraki.arbol.Tree;

import java.util.LinkedList;
import java.util.List;

public class EstructuraArbol {

    private PointerTree<Regla> arbol;
    private Node<Regla> nodoActual;
    private int scopeCounter;
    private int niveles;

    public EstructuraArbol() {
        this.scopeCounter = 0;
        Regla regla = new Regla("Meraki", new LinkedList<Token>());
        this.arbol = new PointerTree<Regla>(regla);
        this.nodoActual = this.arbol.getRoot();
        this.scopeCounter++;
        this.niveles = 0;
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
        for (int i = 0; i < regla.getTokens().size(); i++) {
            Token tok = regla.getTokens().get(i);
            Node<Regla> nodo = this.nodoActual;
            if (tok.getTipoTokenTerminal().equals(TipoTokenTerminal.LLAVEI)) {
                this.scopeCounter++;
                tok.setScope(this.scopeCounter);
                List<Token> nextTokens = new LinkedList<Token>();
                for (int j = i; j < regla.getTokens().size(); j++) {
                    nextTokens.add(regla.getTokens().get(j));
                }
                Regla bloque = new Regla("BloqueCodigo", nextTokens);
                reglaActual = bloque;
                Node<Regla> nuevoNodo = new PointerTreeNode<Regla>(bloque, nodo);
                this.nodoActual.addChild(nuevoNodo);
                nodo = nuevoNodo;
                this.nodoActual = nodo;
            }
            if (nuevoNivel) {
                Node<Regla> nodoRegla = new PointerTreeNode<Regla>(reglaActual, this.nodoActual);
                this.nodoActual.addChild(nodoRegla);
                nuevoNivel = false;
            } else if (tok.getTipoTokenTerminal().equals(TipoTokenTerminal.LLAVEF)) {
                for (int k = 0; k < niveles; k++) {
                    this.nodoActual = this.nodoActual.getParent();
                }
                Node<Regla> nodoRegla = new PointerTreeNode<Regla>(reglaActual, this.nodoActual);
                this.nodoActual.addChild(nodoRegla);
            }
        }
    }

}
