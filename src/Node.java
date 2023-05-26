public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        if(left != null && right != null) {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left.value +
                    ", right=" + right.value +
                    '}';
        } else if (left != null) {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left.value +
                    '}';
        } else if (right != null) {
            return "Node{" +
                    "value=" + value +
                    ", right=" + right.value +
                    '}';
        } else {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
