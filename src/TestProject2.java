import java.io.*;

public class TestProject2 {

    static BufferedReader fileReader;

    public static void main(String[] args){
        //System.out.println("Hello World - Kushagra Bharti");
        TestProject2 test = new TestProject2("datafile.txt");
        readFileContents();

    }

    public TestProject2(String filename){

        try {

            fileReader = new BufferedReader(new FileReader(filename));
            while(readFileContents());

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static boolean readFileContents() {

        if (fileReader == null) {
            System.out.println("File not found, open file first");
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

                Article artcicle = new Article(id, title, author);
                System.out.printf("Testing \n %s\n", artcicle);

                String keyword;
                int numKeys = Integer.parseInt(fileReader.readLine());
                for (int i = 0; i < numKeys; i++) {
                    keyword = fileReader.readLine();
                    System.out.printf("Testing\n %s\n", keyword);
                }
                fileReader.readLine();

            }

            catch (NumberFormatException e) {

                System.out.println("Error: Number is expected");
                return false;

            }

            catch (Exception e) {

                System.out.println("Some fatal error occured");
                return false;

            }

        }

        return true;

    }

}