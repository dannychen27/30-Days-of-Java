package JavaOtherTopics.FileReading;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; // implementation
import java.util.List;  // interface
import java.util.Scanner;

public class FileReading {

    public static void main(String[] args) {
        try {
            File filePath = new File("src/JavaConstructs/FileReading/scores.txt");
            Scanner scanner = new Scanner(filePath);
            List<Integer> scores = new ArrayList<>();  // Arrays are terrible, lists are awesome.
            // Scanner scanner = new Scanner("./scores.txt");   source is a String, which is wrong
            while (scanner.hasNextInt()) {
                Integer currentInt = scanner.nextInt();
                scores.add(currentInt);
            }
            scanner.close();
            System.out.println(scores); // [10, 20, 30, 40, 50]

            File filePath2 = new File("src/JavaConstructs/FileReading/players.txt");
            Scanner scanner2 = new Scanner(filePath2);
            List<String> players = new ArrayList<>();
            while (scanner2.hasNextLine()) {
                String currentPlayer = scanner2.nextLine();
                players.add(currentPlayer);
            }
            scanner2.close();
            System.out.println(players); // [Ross Lynch, Shawn Mendes, Charlie Puth, Jordan Maron, Felix Kjellberg]
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
