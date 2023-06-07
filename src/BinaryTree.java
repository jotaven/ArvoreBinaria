import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Student student) {
        this.root = new Node(student);
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

        //teste pos
        //System.out.printf("\nfloor: %d. edgeLines: %d. firstSpaces: %d. betweenSpaces: %d\n", floor, edgeLines, firstSpaces, betweenSpaces);

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.student.rgm);
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

                // -2 ou -1 espaços (qual funciona melhor?) LEMBRETE
                printWhitespaces(i + i + String.valueOf(node.student.rgm).length() - 2);

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

    public void insert(Student student) {
        root = insertRecursive(root, student);
    }

    private Node insertRecursive(Node current, Student student) {
        if (current == null) {
            return new Node(student);
        }

        if (student.rgm < current.student.rgm) {
            current.left = insertRecursive(current.left, student);
        } else if (student.rgm > current.student.rgm) {
            current.right = insertRecursive(current.right, student);
        }

        return current;
    }

    public boolean remove(int value) {
        if (isEmpty()) {
            System.out.println("Árvore vazia!");
            return false;
        }
        return removeRecursive(root, value) != null;
    }

    public Node removeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.student.rgm) {
            current.left = removeRecursive(current.left, value);
        } else if (value > current.student.rgm) {
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
                current.student = aux.student;
                current.left = removeRecursive(current.left, value);
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
            if (node.student.rgm == value) {
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

    public void printInOrder(boolean string) {
        if (string) {
            printInOrderStringRecursive(root);
        } else {
            printInOrderRecursive(root);
        }
        System.out.println();
    }

    private void printInOrderRecursive(Node current) {
        if (current != null) {
            printInOrderRecursive(current.left);
            System.out.print(current.student.rgm + " ");
            printInOrderRecursive(current.right);
        }
    }

    private void printInOrderStringRecursive(Node current) {
        if (current != null) {
            printInOrderStringRecursive(current.left);
            System.out.print(current.student.name + " ");
            printInOrderStringRecursive(current.right);
        }
    }

    public void printPosOrder(boolean string) {
        if (string) {
            printPosOrderStringRecursive(root);
        } else {
            printPosOrderRecursive(root);
        }
        System.out.println();
    }

    private void printPosOrderRecursive(Node current) {
        if (current != null) {
            printPosOrderRecursive(current.left);
            printPosOrderRecursive(current.right);
            System.out.print(current.student.rgm + " ");
        }
    }

    private void printPosOrderStringRecursive(Node current) {
        if (current != null) {
            printPosOrderStringRecursive(current.left);
            printPosOrderStringRecursive(current.right);
            System.out.print(current.student.name + " ");
        }
    }


    public void printPreOrder(boolean string) {
        if (string) {
            printPreOrderStringRecursive(root);
        } else {
            printPreOrderRecursive(root);
        }
        System.out.println();
    }

    private void printPreOrderRecursive(Node current) {
        if (current != null) {
            System.out.print(current.student.rgm + " ");
            printPreOrderRecursive(current.left);
            printPreOrderRecursive(current.right);
        }
    }

    private void printPreOrderStringRecursive(Node current) {
        if (current != null) {
            System.out.print(current.student.name + " ");
            printPreOrderStringRecursive(current.left);
            printPreOrderStringRecursive(current.right);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }
}
