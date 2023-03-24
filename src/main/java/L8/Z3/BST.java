package L8.Z3;


import L8.Z3.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class BST<E> {

    private class Node {
        Node parent;
        Node left;
        Node right;
        E key;
        int leftHeight, rightHeight;
        int overLoad;
        int leftNodes, rightNodes;
        int leftMaxOverLoad, rightMaxOverLoad;
        int leftLeaves, rightLeaves;

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
            System.out.printf("%" + space + "s",root);
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
                    System.out.printf("%" + space + "s", currentList.get(a));
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

    public Node search(E key, Node beg){
        if(beg == null){
            return null;
        }
        E val = beg.key;
        if(root == null || comp.compare(key, val) == 0)
            return beg;
        if(comp.compare(key, val) < 0){
            return search(key, beg.left);
        } else {
            return search(key, beg.right);
        }
    }

    public void insert(E key){
        System.out.println("Dodano: " + key);
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



    public E delete(E key, Node begin){
        Node y;
        Node x;
        Node delete = search(key, begin);
        if(delete.left == null || delete.right == null){
            y = delete;
        } else {
            y = nodeSuccessor(delete.key);
        }
        if(y.left != null){
            x = y.left;
        } else {
            x = y.right;
        }

        if(x != null)
            x.parent = y.parent;
        if(y.parent == null){
            root = x;
        } else {
            if(y == y.parent.left){
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        if(y != delete){
            E temp = delete.key;
            delete.key = y.key;
            y.key = temp;
        }

        return y.key;
    }

    public void getCharacteristics(E key, Node begin){
        Node n = search(key, begin);

        n.leftHeight = getHeight(n.left);
        n.rightHeight = getHeight(n.right);
        n.overLoad = n.rightHeight - n.leftHeight;
        n.leftNodes = getNodes(n.left);
        n.rightNodes = getNodes(n.right);
        n.leftMaxOverLoad = maxOverload(n.left);
        n.rightMaxOverLoad = maxOverload(n.right);
        n.leftLeaves = getLeaves(n.left);
        n.rightLeaves = getLeaves(n.right);

        System.out.println("Wysokość lewego poddrzewa: " + n.leftHeight);
        System.out.println("Wysokość prawego poddrzewa: " + n.rightHeight);
        System.out.println("Przeciążenie wierzchołka: " + n.overLoad);
        System.out.println("Liczba węzłów w lewym poddrzewie: " + n.leftNodes);
        System.out.println("Liczba węzłów w prawym poddrzewie: " + n.rightNodes);
        System.out.println("Maksymalne przeciążenie w lewym poddrzewie: " + n.leftMaxOverLoad);
        System.out.println("Maksymalne przeciążenie w prawym poddrzewie: " + n.rightMaxOverLoad);
        System.out.println("Ilość liści w lewym poddrzewie: " + n.leftLeaves);
        System.out.println("Ilość liści w prawym poddrzewie: " + n.rightLeaves);
    }

    private int getHeight(Node begin){
        if(begin == null)
            return 0;
        int height = 1;
        int left = 0, right = 0;
        if(begin.left != null){
            left = getHeight(begin.left);
        }
        if(begin.right != null){
            right = getHeight(begin.right);
        }
        return height + Math.max(left, right);
    }

    private int getNodes(Node begin){
        int nodes = 1;
        int left = 0;
        int right = 0;
        if(begin.left != null){
            left = getNodes(begin.left);
        }
        if(begin.right != null){
            right = getNodes(begin.right);
        }
        return nodes + left + right;
    }

    private int maxOverload(Node begin){
        int ol = getHeight(begin.right) - getHeight(begin.left);
        int left = 0;
        int right = 0;
        if(begin.left != null){
            left = maxOverload(begin.left);
        }
        if(begin.right != null){
            right = maxOverload(begin.right);
        }
        if(Math.abs(left) > Math.abs(right)){
            if(Math.abs(left) > Math.abs(ol))
                ol = left;
        } else {
            if(Math.abs(right) > Math.abs(ol))
                ol = right;
        }
        return ol;
    }

    private int getLeaves(Node begin){
        int leaves = 0;
        int left = 0;
        int right = 0;
        if(begin.left == null && begin.right == null){
            leaves++;
        }
        if(begin.left != null){
            left = getLeaves(begin.left);
        }
        if(begin.right != null){
            right = getLeaves(begin.right);
        }
        return leaves + left + right;
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
