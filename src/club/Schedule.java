package club;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Schedule {
    private FitnessClass[] classes;
    private int numClasses;

    public Schedule() {
        final int NUM_CLASSES_FILE = 15;

        this.classes = new FitnessClass[NUM_CLASSES_FILE];
        this.numClasses = 0;
    }


    public FitnessClass[] getClasses() {
        return classes;
    }

    public int getNumClasses() {
        return numClasses;
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
            Offer offer = Offer.valueOf(tokens.nextToken().toUpperCase());
            Instructor instructor = Instructor.valueOf(tokens.nextToken());
            Time time =  Time.valueOf(tokens.nextToken().toUpperCase());
            Location location =  Location.valueOf(tokens.nextToken().toUpperCase()); // Location

            FitnessClass newClass = new FitnessClass(offer, instructor, location, time);


            this.classes[this.numClasses] = newClass;
            this.numClasses++;
        }
    }

    public boolean validClassStudio(Location location, Offer offer, Instructor instructor){
        for(int i = 0; i < this.numClasses; i++){
            if(this.classes[i].getClassInfo() != this.)
        }
    }

}