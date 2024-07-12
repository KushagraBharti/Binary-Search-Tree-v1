import java.io.*;

public class TestProject {
    BufferedReader fileReader;
    BST<String> bst;

    public static void main(String[] args) {
        //System.out.println("Hello World");
        TestProject test = new TestProject("datafile.txt");
        test.bst.inorder();

    }

    public TestProject(String filename) {
        try {
            bst = new BST<String>();
            fileReader = new BufferedReader(new FileReader(filename));
            while (readFileContents());
        }
        catch(IOException e) {
            e.printStackTrace();
            //System.out.println(e);
        }
    }

    public boolean readFileContents() {
        if (fileReader == null) {
            System.out.println("Error: You  must open the file first.");
            return false;
        }
        else {
            try {
                String data = fileReader.readLine();
                if (data == null) return false;
                //System.out.printf("Testing %s\n", data);
                int id = Integer.parseInt(data);
                String title = fileReader.readLine();
                String author = fileReader.readLine();

                Article article = new Article(id, title, author);
                //System.out.printf("Testing %s\n", article);

                String keyword;
                int numKeys = Integer.parseInt(fileReader.readLine());
                for (int i=0; i<numKeys; i++) {
                    keyword = fileReader.readLine();
                    bst.insert(keyword, article);
                    //System.out.printf("Testing %s\n", keyword);
                }
                fileReader.readLine();
            }
            catch(NumberFormatException e) {
                System.out.println("Error: Number is expected!");
                return false;
            }
            catch(Exception e) {
                System.out.println("Error: Fatal error has occured: " + e);
                return false;
            }
        }

        return true;
    }
}