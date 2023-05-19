public class Main {
    public static void main(String[] args) {

        BinaryTree a = new BinaryTree(6);

        System.out.println(a.root.value);
        a.insert(2);
        a.insert(8);
        a.insert(1);
        a.insert(4);
        a.insert(3);
        System.out.print("In-order: ");
        a.printInOrder();
        System.out.print("Pos-Order: ");
        a.printPosOrder();
        System.out.print("Pre-Order: ");
        a.printPreOrder();

        a.remove(3);
        a.printInOrder();
        a.printTree();

        System.out.println();
        System.out.println(a.search(3));
        System.out.println(a.search(4));
    }
}