import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Keywords {

    public ArrayList<String> getKeywords() throws FileNotFoundException {
        ArrayList<String> keywordList = new ArrayList<>();

        //read the file into the arrayList
        try {
            File myObj = new File("C:\\Users\\ericd\\IdeaProjects\\BasedBot\\mavenBuild\\src\\main\\java\\keywords.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                keywordList.add(data);
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return keywordList;
    }



}





