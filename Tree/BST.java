import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BST {
    private Node root;

    public void insert(Student data) {
        Node pointer = this.root;
        Node parent = null;
        while (pointer != null) {
            parent = pointer;
            if (pointer.getData().getStudentLastName().toLowerCase()
                    .compareTo(data.getStudentLastName().toLowerCase()) > 0) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }
        if (root == null) {
            root = new Node(data, null, null, parent);
        } else if (parent.getData().getStudentLastName().compareTo(data.getStudentLastName()) > 0) {

            parent.left = new Node(data, null, null, parent);
        } else {

            parent.right = new Node(data, null, null, parent);
        }
    }

    public void inorder(Node root, String output) {
        if (root == null) {
            return;
        }
        inorder(root.left, output);
        write(root, output);
        inorder(root.right, output);

    }

    public void BreathFirstSearch(String output) {
        Queue<Node> a = new LinkedList<Node>();
        if (root != null) {
            a.add(root);
        }
        while (!(a.isEmpty())) {
            Node q = a.remove();
            write(q, output);
            if (q.right != null) {
                a.add(q.right);
            }
            if (q.left != null)
                a.add(q.left);
        }

    }

    public static void write(Node root, String outputfile) {
        StringBuilder T = new StringBuilder();
        T.append("Student Number: ").append(root.getData().getStudentNumber()).append(" \t ").append("HomeDepartment: ")
                .append(root.getData().getHomeDepartment()).append(" \t ").append("Program: ")
                .append(root.getData().getProgram()).append(" \t ").append("Year: ").append(root.getData().getYear())
                .append("\t").append("Student LastName: ").append(root.getData().getStudentLastName()).append("\n");
        try {
            FileWriter writer = new FileWriter(outputfile, true);
            BufferedWriter buff = new BufferedWriter(writer);

            buff.write(String.valueOf(T));
            // buff.append(String.valueOf(T));

            // writer.write("\n");
            // writer.close();
            buff.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Node getRoot() {
        return this.root;
    }

    public void delete(Student student) {
        root = delete(student, root);
    }

    public Node delete(Student student, Node p) {
        if (p == null) { // not found
            return p;
        }

        if (student.getStudentLastName().toLowerCase().compareTo(p.getData().getStudentLastName().toLowerCase()) < 0) { // remove
                                                                                                                        // from
                                                                                                                        // left
                                                                                                                        // child
            p.left = delete(student, p.left);
        } else if (student.getStudentLastName().compareTo(p.getData().getStudentLastName()) > 0) {
            p.right = delete(student, p.right);
        } else if (p.left != null && p.right != null) { // p has two children
            // step1: find the min node on the right child
            // step2: copy min node to p, and delete min node from right subtree
            p.data = findMin(p.right).data;
            p.right = delete(p.data, p.right);
        } else { // p ahs less than two children
            return (p.left == null) ? p.right : p.left;
        }

        return p;

    }

    public Node findMin(Node p) { // find the min node
        if (p == null) {
            return p;
        }
        if (p.left == null) {
            return p;
        }
        return findMin(p.left);
    }

}
