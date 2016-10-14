package ru.innopolis.mputilov;

import java.util.*;

/**
 * Created by mputilov on 13/10/16.
 */
public class Node2 implements Tree {
    private Tree leftChild;
    private Tree rightChild;
    private int depth;

    public Node2(Tree leftChild, Tree rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    private Collection<Tree> getCollectionOfChildren() {
        return Arrays.asList(leftChild, rightChild);
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

        return getSetOfChildren().equals(node2.getSetOfChildren()) && getDepth() == node2.getDepth();
    }


    @Override
    public int hashCode() {
        return Objects.hash(Objects.hash(leftChild) + Objects.hash(rightChild), getDepth());
    }

    @Override
    public String toString() {
        return "(" + formatString(leftChild) + formatString(rightChild) + ")";
    }

    private String formatString(Tree child) {
        return child == null ? "" : child.toString();
    }


    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public void setDepth(int depth) {
        this.depth = depth;
    }
}
