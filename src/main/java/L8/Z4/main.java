package L8.Z4;

import L8.Z1.Comparators.Comparator;

public class main {

    public static void main(String[] args) {
        RBTree<Integer> rbTree = new RBTree<>(new Comparator<>());

        rbTree.insert(8);
        rbTree.insert(4);
        System.out.println("\nPoczatkowe drzewo RB: ");
        rbTree.print();
        rbTree.insert(12);
        System.out.println("Drzewo po dodaniu 12:  (Przypadek: rodzic czarny)");
        rbTree.print();
        rbTree.insert(5);
        System.out.println("Drzewo po dodaniu 5:  (Przypadek: rodzic czerwony, stryj czerwony)");
        rbTree.print();
        rbTree.insert(6);
        System.out.println("Drzewo po dodaniu 6:  (Przypadek: rodzic czerwony, stryj (który jest null'em) czarny)");
        rbTree.print();
        rbTree.insert(3);
        System.out.println("Drzewo po dodaniu 3:  (Przypadek: rodzic czerwony, stryj czerwony)");
        rbTree.print();
        rbTree.insert(2);
        System.out.println("Drzewo po dodaniu 2:  (Przypadek: rodzic czerwony, stryj (który jest null'em) czarny)");
        rbTree.print();
        rbTree.insert(13);
        rbTree.insert(10);
        rbTree.insert(9);
        rbTree.insert(7);


        System.out.println("Finalne drzewo RB: ");
        rbTree.print();

        System.out.println("In-order: ");
        rbTree.inOrder(rbTree.root);
        System.out.println("end");
    }

}
