package ru.innopolis.mputilov;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by mputilov on 13/10/16.
 */
public class TreeGenerator {
    private int maxHeight;
    private int currentHeight;

    public TreeGenerator(int maxHeight) {
        this(maxHeight, 1);
    }

    private TreeGenerator(int maxHeight, int currentHeight) {
        if (maxHeight < currentHeight) {
            throw new RuntimeException("Max height couldn't be greater than current height");
        }
        if (currentHeight < 1) {
            throw new RuntimeException("Current height couldn't be less than 1");
        }
        this.maxHeight = maxHeight;
        this.currentHeight = currentHeight;
    }

    public Set<Tree> generateAllIsomorphicTrees() {
        Collection<Tree> trees = new ArrayList<>();
        trees.add(new Node2(null, null));
        trees.add(new Node3(null, null, null));
        for (; currentHeight < maxHeight; currentHeight++) {
            List<Tree> treesWithNode2AsRoot = new HashSet<>(joinWithNode2(trees)).stream().collect(toList());
            List<Tree> treesWithNode3AsRoot = new HashSet<>(joinWithNode3(trees)).stream().collect(toList());

            trees = concatLists(treesWithNode2AsRoot, treesWithNode3AsRoot);
        }

        return new HashSet<>(trees);
    }

    private Collection<Tree> concatLists(Collection<Tree> firstList, Collection<Tree> secondList) {
        firstList.addAll(secondList);
        return firstList;
    }

    /**
     * Node-2 is a root. Join trees with themselves 2 times to create all different children
     *
     * @param trees possible subtrees as children
     * @return all new combinations with node-2 as a root and all possible children
     */
    private List<Tree> joinWithNode2(Collection<Tree> trees) {
        List<Tree> joined = new ArrayList<>();
        for (Tree firstChild : trees) {
            for (Tree secondChild : trees) {
                //из-за того что это set, дубликаты (согласно структуре) элиминируются, и количество не будет большим
                joined.add(new Node2(firstChild, secondChild));
            }
        }
        return joined;
    }

    /**
     * Node-3 is a root. Join trees with themselves 3 times to create all different children
     *
     * @param trees possible subtrees as children
     * @return all new combinations with node-3 as a root and all possible children
     */
    private List<Tree> joinWithNode3(Collection<Tree> trees) {
        List<Tree> joined = new ArrayList<>();
        for (Tree firstChild : trees) {
            for (Tree secondChild : trees) {
                for (Tree thirdChild : trees) {
                    joined.add(new Node3(firstChild, secondChild, thirdChild));
                }
            }
        }
        return joined;
    }
}
