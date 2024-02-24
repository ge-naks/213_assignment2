package club;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Schedule {
    private FitnessClass[] classes;
    private int numClasses;

    public Schedule() {

    }

    public void load(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, " ");
                parseTokens(tokens);
            }
        }
    }


    private void parseTokens(StringTokenizer tokens) {
        if (tokens.countTokens() >= 4) {
            String className = tokens.nextToken(); // Fitness class name
            String instructor = tokens.nextToken(); // Instructor name
            String timeStr = tokens.nextToken(); // Time string
            String location = tokens.nextToken(); // Location

            // Convert time string to Time enum
            Time time;
            switch (timeStr.toLowerCase()) {
                case "morning":
                    time = Time.MORNING;
                    break;
                case "afternoon":
                    time = Time.AFTERNOON;
                    break;
                case "evening":
                    time = Time.EVENING;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid time: " + timeStr);
            }

            // Create FitnessClass object and store it or do further processing
            FitnessClass fitnessClass = new FitnessClass(Offer.valueOf(className), Instructor.valueOf(instructor),
                    Location.valueOf(location), time);
            // You can store fitnessClass or do something else with it
        } else {
            System.err.println("Invalid line: " + tokens.toString());
        }
    }

}