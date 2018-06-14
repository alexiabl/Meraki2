package automatas.meraki.arbol;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexia Borchgrevink
 */
public class PointerTreeNode<T> implements Node<T> {

    /* @TODO add missing attributes and fill methods. */


    private Node<T> parent;
    private List<Node<T>> children;
    private T label;

    public PointerTreeNode(T label, Node parent) {
        this.label = label;
        this.parent = parent;
        this.children = new LinkedList<Node<T>>();
    }

    /**
     * Sets the value element of the node.
     *
     * @param data the element to set as value.
     */
    public void setLabel(T data) {
        this.label = data;
    }

    /**
     * Returns the value of the node.
     *
     * @return value.
     */
    public T getLabel() {
        return this.label;
    }

    /**
     * Returns the parent node of this node.
     *
     * @return a node.
     */
    public Node<T> getParent() {
        return this.parent;
    }

    /**
     * Adds the given node as a child of the current node.
     *
     * @param child the child to add.
     */
    public void addChild(Node<T> child) {
        this.getChildren().add(child);
    }

    /**
     * Adds the given node as a child of the node in the given position.
     *
     * @param index the position.
     * @param child the child to be added.
     */
    public void addChildAt(int index, Node<T> child) {
        this.getChildren().add(index, child);
    }

    /**
     * Clears the list of children of the node.
     */
    public void removeChildren() {
        this.getChildren().clear();
    }

    /**
     * Adds the given node as a child of the node in the given position.
     *
     * @param index the index of the child to be removed.
     * @return the removed child.
     */
    public Node<T> removeChildAt(int index) {
        return this.getChildren().remove(index);
    }

    /**
     * Returns a list of nodes containing the children of the node.
     *
     * @return list of nodes.
     */
    public List<Node<T>> getChildren() {
        return this.children;
    }

    /**
     * Returns the child node at position {@code index}.
     *
     * @param index the child position.
     * @return node child.
     */
    public Node<T> getChildAt(int index) {
        return this.getChildren().get(index);
    }

    public Node<T> findChild(String name) {
        Node<T> findNode = null;
        for (Node<T> node : this.getChildren()
                ) {
            if (node.getLabel().equals(name)) {
                findNode = node;
                break;
            }
        }
        return findNode;
    }


}