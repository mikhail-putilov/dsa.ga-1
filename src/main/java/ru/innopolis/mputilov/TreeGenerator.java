package ru.innopolis.mputilov;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mputilov on 13/10/16.
 */
public class TreeGenerator {
    private int maxHeight;
    private int currentHeight;
    private Set<Tree> generatedTrees = new HashSet<>();

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
        if (currentHeight == 1) {
            setBase();
        }
    }

    public void addTree(Tree t) {
        generatedTrees.add(t);
    }

    private void setBase() {
        generatedTrees.add(new Node2(null, null));
        generatedTrees.add(new Node3(null, null, null));
    }

    public Set<Tree> generateAllIsomorphicTrees() {
        if (maxHeight == currentHeight) {
            return generatedTrees;
        }
        
        //создаем новый инстанс генератора с новым слоем всех разных видов деревьев с maxHeight меньше на единицу
        TreeGenerator newGenerator = new TreeGenerator(maxHeight, currentHeight + 1);
        //берем 2-node как корень нового дерева и перебираем со всеми дереьвями которые ранее были сгенерированы
        for (Tree firstChild : generatedTrees) {
            for (Tree secondChild : generatedTrees) {
                //из-за того что это set, дубликаты (согласно структуре) элиминируются, и количество не будет большим
                newGenerator.addTree(new Node2(firstChild, secondChild));
            }
        }
        //то же самое происходит и с 3-node: берем его в качестве корня и присоединяем к его детям все комбинации
        //ранее сгенерированных деревьев
        for (Tree firstChild : generatedTrees) {
            for (Tree secondChild : generatedTrees) {
                for (Tree thirdChild : generatedTrees) {
                    newGenerator.addTree(new Node3(firstChild, secondChild, thirdChild));
                }
            }
        }
        return newGenerator.generateAllIsomorphicTrees();
    }
}
