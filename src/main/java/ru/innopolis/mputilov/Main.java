package ru.innopolis.mputilov;

import java.util.Set;

/**
 * Created by mputilov on 13/10/16.
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            System.out.println("Different trees with height=" + (i + 1));
            int counter = 1;
            TreeGenerator generator = new TreeGenerator(i);
            Set<Tree> trees = generator.generateAllIsomorphicTrees();
            for (Tree t : trees) {
                System.out.println("" + counter++ + "\t" + t.toString());
            }
        }

    }
}
