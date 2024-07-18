import java.io.*;
import java.util.Scanner;

public class TestProject {
    BufferedReader fileReader;
    BST<String> bst;

    public static void main(String[] args) {
        TestProject test = new TestProject("datafile.txt");
        test.bst.inorder();

        // Prompt the user to enter a key and perform the search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a key to search: ");
        String key = scanner.nextLine();
        test.bst.search(key);
        scanner.close();
    }

    public TestProject(String filename) {
        try {
            bst = new BST<String>();
            fileReader = new BufferedReader(new FileReader(filename));
            while (readFileContents());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean readFileContents() {
        if (fileReader == null) {
            System.out.println("Error: You must open the file first.");
            return false;
        } else {
            try {
                String data = fileReader.readLine();
                if (data == null) return false;
                int id = Integer.parseInt(data);
                String title = fileReader.readLine();
                String author = fileReader.readLine();

                Article article = new Article(id, title, author);

                String keyword;
                int numKeys = Integer.parseInt(fileReader.readLine());
                for (int i = 0; i < numKeys; i++) {
                    keyword = fileReader.readLine();
                    bst.insert(keyword, article);
                }
                fileReader.readLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Number is expected!");
                return false;
            } catch (Exception e) {
                System.out.println("Error: Fatal error has occurred: " + e);
                return false;
            }
        }

        return true;
    }
}
