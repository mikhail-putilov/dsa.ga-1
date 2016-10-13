package ru.innopolis.mputilov;

import java.util.*;

/**
 * Created by mputilov on 13/10/16.
 */
public class Node2 implements Tree {
    private Tree leftChild;
    private Tree rightChild;

    private Collection<Tree> getCollectionOfChildren() {
        return Arrays.asList(leftChild, rightChild);
    }

    public Node2(Tree leftChild, Tree rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Tree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Tree leftChild) {
        this.leftChild = leftChild;
    }

    public Tree getRightChild() {
        return rightChild;
    }

    public void setRightChild(Tree rightChild) {
        this.rightChild = rightChild;
    }

    private Set<Tree> getSetOfChildren() {
        Set<Tree> set = new HashSet<>();
        set.add(leftChild);
        set.add(rightChild);
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node2 node2 = (Node2) o;

        return getSetOfChildren().equals(node2.getSetOfChildren());
    }


    @Override
    public int hashCode() {
        return Objects.hash(Objects.hash(leftChild) + Objects.hash(rightChild));
    }

    @Override
    public String toString() {
        return "(" + formatString(leftChild) + formatString(rightChild) + ")";
    }

    private String formatString(Tree child) {
        return child == null ? "" : child.toString();
    }


}
