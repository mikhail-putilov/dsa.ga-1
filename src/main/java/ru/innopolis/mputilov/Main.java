package ru.innopolis.mputilov;

import java.util.Set;

/**
 * Created by mputilov on 13/10/16.
 */
public class Main {
    public static void main(String[] args) {
        int counter = 1;
        TreeGenerator generator = new TreeGenerator(3);
        Set<Tree> trees = generator.generateAllIsomorphicTrees();
        for (Tree t : trees) {
            System.out.println("" + counter++ + "\t" + t.toString());
        }
    }
}
