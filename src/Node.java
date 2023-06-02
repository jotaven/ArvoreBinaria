public class Node {
    Student student;
    Node left;
    Node right;

    public Node(Student student) {
        this.student = student;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        if(left != null && right != null) {
            return "Node{" +
                    "value=" + student.name +
                    ", left=" + left.student.name +
                    ", right=" + right.student.name +
                    '}';
        } else if (left != null) {
            return "Node{" +
                    "value=" + student.name +
                    ", left=" + left.student.name +
                    '}';
        } else if (right != null) {
            return "Node{" +
                    "value=" + student.name +
                    ", right=" + right.student.name +
                    '}';
        } else {
            return "Node{" +
                    "value=" + student.name +
                    '}';
        }
    }
}
