public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int value) {
        this.root = new Node(value);
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
                Node subLeft = current.left;
                while (subLeft.left != null) {
                    subLeft = subLeft.left;
                }

                current.value = subLeft.value;
                current.right = removeRecursive(current.right, subLeft.value);
            }
        }
        return current;
    }

    // Esquerda, Elemento, Direita
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
    // Pós-Ordem: Esquerda, Direita, Elemento
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

    // Pré-Ordem: Elemento, Esquerda, Direita
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
}
