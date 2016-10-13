package ru.innopolis.mputilov;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by mputilov on 13/10/16.
 */
public class Node3 implements Tree {
    private Tree leftChild;
    private Tree midChild;
    private Tree rightChild;

    public Node3(Tree leftChild, Tree midChild, Tree rightChild) {
        this.leftChild = leftChild;
        this.midChild = midChild;
        this.rightChild = rightChild;
    }

    private Set<Tree> getSetOfChildren() {
        Set<Tree> set = new HashSet<>();
        set.add(leftChild);
        set.add(rightChild);
        set.add(midChild);
        return set;
    }

    public Tree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Tree leftChild) {
        this.leftChild = leftChild;
    }

    public Tree getMidChild() {
        return midChild;
    }

    public void setMidChild(Tree midChild) {
        this.midChild = midChild;
    }

    public Tree getRightChild() {
        return rightChild;
    }

    public void setRightChild(Tree rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node3 node3 = (Node3) o;
        return getSetOfChildren().equals(node3.getSetOfChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Objects.hash(leftChild) + Objects.hash(rightChild) + Objects.hash(midChild), Objects.hash(3));
    }

    @Override
    public void print() {

    }
}
