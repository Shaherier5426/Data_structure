import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment3 {
    private static BST tree = new BST();

    public static void main(String[] args) {
        String Read = args[0] + ".txt";
        String BFS = args[1] + ".txt";
        String DFS = args[2] + ".txt";

        try {
            File file = new File(Read);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Student student = new Student(line);

                if (student.getOperationCode().equals("I")) {
                    tree.insert(student);

                } else {
                    tree.delete(student);

                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // return bst;
        }

        System.out.println("Breath search tree made......");

        tree.BreathFirstSearch(BFS);

        System.out.println("Inorder search tree made......");
        tree.inorder(tree.getRoot(), DFS);

    }

}
