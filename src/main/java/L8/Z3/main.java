package L8.Z3;

import L8.Z3.Comparators.Comparator;

public class main {


    public static void main(String[] args) {
        BST bst = new BST<>(new Comparator<>());

        bst.insert(10);
        bst.insert(4);
        bst.insert(8);
        bst.insert(9);
        System.out.println("Gotowe drzewo: ");
        bst.print();
        bst.insert(11);
        bst.insert(6);
        bst.insert(1);
        bst.insert(16);
        System.out.println("Gotowe drzewo: ");
        bst.print();
    }
}
