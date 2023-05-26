import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int value) {
        this.root = new Node(value);
    }

    public void printTree() {
        int maxLevel = maxLevel(root);
        List<Node> treeRoot = new ArrayList<>();
        treeRoot.add(root);
        System.out.println("Max level: " + maxLevel);
        printSubTree(treeRoot, 1, maxLevel);
    }

    private void printSubTree(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        //System.out.printf("\nfloor: %d. edgeLines: %d. firstSpaces: %d. betweenSpaces: %d\n", floor, edgeLines, firstSpaces, betweenSpaces);

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (Node node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (node.right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printSubTree(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private boolean isAllElementsNull(List<Node> list) {
        for (Node node : list) {
            if (node != null)
                return false;
        }

        return true;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public void remove(int value) {
        if (isEmpty()) {
            System.out.println("Árvore vazia!");
            return;
        }
        removeRecursive(root, value);
    }

    public Node removeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = removeRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = removeRecursive(current.right, value);
        } else {
            if (current.left == null && current.right == null) {
                current = null;
            } else if (current.right == null) {
                current = current.left;
            } else if (current.left == null) {
                current = current.right;
            } else {
                Node aux = current.left;
                while (aux.right != null) {
                    aux = aux.right;
                }
                current.value = aux.value;
                current.left = removeRecursive(current.left, aux.value);
            }
        }
        return current;
    }

    public Node search(int value) {
        if (isEmpty()) {
            System.out.println("Árvore vazia!");
            return null;
        }
        return searchRecursive(this.root, value);
    }

    private Node searchRecursive(Node node, int value) {

        Node search = null;

        if (node != null) {
            if (node.value == value) {
                search = node;
                return search;
            }
            search = searchRecursive(node.left, value);
            if (search == null) {
                search = searchRecursive(node.right, value);
            }
        }
        return search;

    }

    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }

    private void printInOrderRecursive(Node current) {
        if (current != null) {
            printInOrderRecursive(current.left);
            System.out.print(current.value + " ");
            printInOrderRecursive(current.right);
        }
    }

    public void printPosOrder() {
        printPosOrderRecursive(root);
        System.out.println();
    }

    private void printPosOrderRecursive(Node current) {
        if (current != null) {
            printPosOrderRecursive(current.left);
            printPosOrderRecursive(current.right);
            System.out.print(current.value + " ");
        }
    }


    public void printPreOrder() {
        printPreOrderRecursive(root);
        System.out.println();
    }

    private void printPreOrderRecursive(Node current) {
        if (current != null) {
            System.out.print(current.value + " ");
            printPreOrderRecursive(current.left);
            printPreOrderRecursive(current.right);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }
}
