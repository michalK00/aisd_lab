package L8.Z1;

import L8.Z1.Comparators.Comparator;

public class main {

    public static void main(String[] args) throws InterruptedException {

        BST<Integer> bst = new BST<Integer>(new Comparator<Integer>());

        bst.insert(10);
        bst.insert(4);
        bst.insert(8);
        bst.insert(9);
        bst.insert(11);
        bst.insert(6);
        bst.insert(1);
        bst.insert(16);


        bst.preOrder(bst.root);
        System.out.print("end");
        System.out.println();
        bst.inOrder(bst.root);
        System.out.print("end");
        System.out.println();
        bst.postOrder(bst.root);
        System.out.print("end");
        System.out.println();



    }

}
