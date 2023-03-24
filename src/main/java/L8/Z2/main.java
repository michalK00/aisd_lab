package L8.Z2;

import L8.Z2.Comparators.Comparator;

public class main {


    public static void main(String[] args) {
        BST bst = new BST<>(new Comparator<>());

        bst.insert(10);
        bst.insert(4);
        bst.insert(8);
        bst.insert(9);
        bst.insert(11);
        bst.insert(6);
        bst.insert(1);
        bst.insert(16);

        bst.getCharacteristics(10 ,bst.root);

        bst.delete(9, bst.root);
        bst.delete(6, bst.root);

        System.out.println();
        System.out.println("Po usunięciu dwóch wierzchołków: ");
        bst.getCharacteristics(10 ,bst.root);
    }
}
