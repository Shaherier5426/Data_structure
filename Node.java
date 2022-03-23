public class Node {
    protected Student data;
    protected Node left;
    protected Node right;
    private Node parent;
    public Node(Student data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }


    public Student getData() { return data; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
}

