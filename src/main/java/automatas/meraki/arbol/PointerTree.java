package automatas.meraki.arbol;

/**
 * @author Alexia Borchgrevink
 */
public class PointerTree<T> implements Tree<T> {

    private Node<T> root;

    public PointerTree(T label) {
        this.root = new PointerTreeNode<T>(label, null);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return root == null;
    }
}