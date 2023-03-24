package L8.Z4;

import L8.Z1.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class RBTree<E> {

    private class Node{
        private Node left;
        private Node right;
        private Node parent;
        private E key;
        private Color color;

        Node(E key, Node p){
            this.key = key;
            parent = p;
        }



    }
    Node root;
    ComparatorInterface<E> comp;

    public RBTree(ComparatorInterface<E> comp) {
        root = null;
        this.comp = comp;
    }
    public void insert(E key){
        Node y;
        Node x = standardInsert(key);
        x.color = Color.RED;
        while (x != root && x.parent.color == Color.RED) {
            if (x.parent == x.parent.parent.left) {
                y = x.parent.parent.right;
                if (y != null && y.color == Color.RED) {
                    x.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    rightRotate(x.parent.parent);
                }
            } else {
                y = x.parent.parent.left;
                if (y != null && y.color == Color.RED) {
                    x.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    leftRotate(x.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;

    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            root = y;
        } else if(x == x.parent.left){
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;

    }


    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if(y.right != null){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            root = y;
        } else if(x == x.parent.left){
            x.parent.left = y;
        } else{
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }


    private Node standardInsert(E key){
        if(root == null){
            root = new Node(key, null);
            return root;
        }
        Node y = null;
        Node x = root;
        while(x != null){
            y = x;
            if(comp.compare(key, x.key) < 0){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        Node leaf = new Node(key, y);
        if(comp.compare(leaf.key, y.key) < 0){
            y.left = leaf;
        } else {
            y.right = leaf;
        }
        return leaf;
    }

    public void print(){

        int x = 1;
        int space;
        boolean _continue = true;
        ArrayList<Node> currentList = new ArrayList<>();
        ArrayList<Node> nextList = new ArrayList<>();

        if(root == null){
            return;
        } else {
            space = 200/(x+1);
            System.out.printf("%" + space + "s",root.key  + " " + root.color);
            System.out.println();
            currentList.add(root.left);
            currentList.add(root.right);
        }

        while(_continue){
            x = x*2;
            space = 200/(x+1);
            _continue = false;
            for(int a = 0; a < currentList.size(); a++){
                if(currentList.get(a) != null){
                    _continue = true;
                    nextList.add(currentList.get(a).left);
                    nextList.add(currentList.get(a).right);
                    System.out.printf("%" + space + "s", currentList.get(a).key + " " + currentList.get(a).color);
                } else{
                    nextList.add(null);
                    nextList.add(null);
                    System.out.printf("%" + space + "s", "");
                }
            }
            System.out.println();
            System.out.println();
            currentList.clear();
            currentList.addAll(nextList);
            nextList.clear();
        }

    }
    public void inOrder(Node begin) {
        if(begin.left != null) {
            inOrder(begin.left);
        }
        System.out.print(begin.key + " -> ");
        if(begin.right != null){
            inOrder(begin.right);
        }
    }
}
