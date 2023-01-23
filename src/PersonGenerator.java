import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) throws IOException {
        ArrayList<String> Persondata = new ArrayList<>();
        ArrayList<String> person0data = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String ID = " ";
        String firstname = " ";
        String lastname = " ";
        String title = " ";
        String Fullguy = " ";
        int YOB = 0;
        boolean done = false;
        System.out.println("Enter the following information when prompted: ID #, First Name, Last Name, title, Year of Birth");
        do{
            ID = SafeInput.getNonZeroLenString(in,"Enter 6 digit ID number");
            firstname = SafeInput.getNonZeroLenString(in,"Enter First name");
            lastname = SafeInput.getNonZeroLenString(in,"Enter Last name");
            title = SafeInput.getNonZeroLenString(in,"Enter title");
            YOB = SafeInput.getRangedInt(in,"Enter 4 digit year of birth: ",1000,9999);

            person0data.add(new Person(ID, firstname, lastname, title, YOB).toCSVRecord());
            done = SafeInput.getYNConfirm(in,"Would you like to end? Enter Y to quit. Enter N to add another");


        }while(!done);
        System.out.println(person0data);
        Path path = Paths.get("C:\\Users\\legol\\IdeaProjects\\lab01_person\\src\\PersonTestData.txt");
        //create file
        try {
            Path createdFilePath = Files.createFile(path);
            System.out.println("Created a file at : "+createdFilePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Files.write(path, person0data);
    }
}