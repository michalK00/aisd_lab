package L8.Z1;

import L8.Z1.Comparators.ComparatorInterface;

public class BST<E> {

    private class Node {
        Node parent;
        Node left;
        Node right;
        E key;


        Node(E key, Node p){
            this.key = key;
            parent = p;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String toString(){
            return key.toString();
        }
    }

    Node root;
    ComparatorInterface<E> comp;

    public BST(ComparatorInterface<E> comp){
        root = null;
        this.comp = comp;
    }

    public Node getMaximum(Node begin){
        while(begin.left != null){
            begin = begin.left;
        }
        return begin;
    }

    public Node getMinimum(Node begin){
        while(begin.right != null){
            begin = begin.right;
        }
        return begin;
    }

    public Node search(E key, Node beginning){
        if(beginning == null){
            return null;
        }
        E val = beginning.key;
        if(root == null || comp.compare(key, val) == 0)
            return beginning;
        if(comp.compare(key, val) < 0){
            return search(key, beginning.left);
        } else {
            return search(key, beginning.right);
        }
    }

    public void insert(E key){
        System.out.println("Dodano element: " + key);
        if(root == null){
            root = new Node(key, null);
            return;
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
    }



    public Node nodeSuccessor(E key){
        Node node = search(key, root);
        if(node.right != null){
            return getMinimum(node.right);
        }
        Node temp = node.parent;
        while(temp != null && node == temp.right) {
            node = temp;
            temp = temp.parent;
        }
        return temp;
    }

    public Node nodePredecessor(E key){
        Node node = search(key, root);
        if(node.left != null){
            return getMaximum(node);
        }
        Node temp = node.parent;
        while(temp != null && node == temp.left){
            node = temp;
            temp = temp.parent;
        }
        return temp;
    }

    public void inOrder(Node begin){
        if(begin.left != null) {
            inOrder(begin.left);
        }
        System.out.print(begin.key + " -> ");
        if(begin.right != null){
            inOrder(begin.right);
        }
    }

    public void preOrder(Node begin){
        System.out.print(begin.key + " -> ");
        if(begin.left != null){
            preOrder(begin.left);
        }
        if(begin.right != null){
            preOrder(begin.right);
        }
    }

    public void postOrder(Node begin){
        if(begin.left != null){
            postOrder(begin.left);
        }
        if(begin.right != null){
            postOrder(begin.right);
        }
        System.out.print(begin.key + " -> ");
    }


}
