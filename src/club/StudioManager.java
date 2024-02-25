package club;

import java.io.File;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudioManager {
    private MemberList list;
    private Scanner scanner;
    private Schedule schedule;

    public StudioManager() {
        this.list = new MemberList();
        this.scanner = new Scanner(System.in);
        this.schedule = new Schedule();
    }

    public void run() {

        File existingMembers = new File("src/club/memberList.txt");
        File classSchedule = new File("src/club/classSchedule.txt");

        try {
            System.out.println("-list of members loaded-");
            this.list.load(existingMembers);

            for (int i = 0; i < this.list.getSize(); i++) {
                System.out.println(this.list.getMembers()[i]);
            }
            System.out.println("-end of list-");
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error loading members." + e);
        }

        try {
            System.out.println("-Fitness classes loaded-");
            this.schedule.load(classSchedule);
            for (int i = 0; i < this.schedule.getNumClasses(); i++) {
                System.out.println(this.schedule.getClasses()[i]);
            }
            System.out.println("-end of class list-");
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error loading members." + e);

        }

        System.out.println("Studio Manager is up running...");
        while (true) {
            String line = scanner.nextLine().trim(); // Trim to remove leading/trailing whitespace
            if (line.equals("Q")) {
                System.out.println("Studio Manager terminated.");
                scanner.close();
                return; // Exit the method and terminate the program
            } else if (!line.isEmpty()) {
                StringTokenizer tokens = new StringTokenizer(line, " ");
                processCommand(tokens);
            }
        }
    }


    public void processCommand(StringTokenizer tokens) {
        String command = tokens.nextToken();

        switch (command) {
            case "AB":
                parseAB(tokens);
                break;
            case "AF":
                parseAF(tokens);
                break;
            case "AP":
                parseAP(tokens);
                break;
            case "C":
                parseC(tokens);
                break;
            case "S":
                // see class attendance
                break;
            case "PM":
                //to display the members sorted by member profiles
                this.list.printByMember();
                break;
            case "PC":
                this.list.printByCounty();
                break;
            case "PF":
                this.list.printFees();
                break;
            case "R":
                parseR(tokens);
                break;
            case "U":
                // remove from class
                break;
            case "RG":
                // register guest for class
                break;
            case "UG":
                // deregister guest for class
                break;
            case "t":
                for (int i = 0; i < this.list.getSize(); i++) {
                    Member[] temp = this.list.getMembers();
                    System.out.println(temp[i]);
                }
                break;
            default:
                System.out.println(command + " is an invalid command!");
        }

    }


    public Date calendarToDate(Calendar calendar) {
        int todayYear = calendar.get(Calendar.YEAR);
        int todayMonth = calendar.get(Calendar.MONTH) + 1; // Note: Month is zero-based, so add 1
        int todayDay = calendar.get(Calendar.DAY_OF_MONTH);

        return new Date(todayMonth, todayDay, todayYear);
    }

    private void parseAB(StringTokenizer tokens) {
        if (tokens.countTokens() < 4) {
            System.out.println("Missing data tokens.");
            return;
        }
        String fname = tokens.nextToken();
        String lname = tokens.nextToken();
        String strDate = tokens.nextToken();
        if (!Date.tryDate(strDate)) {
            System.out.println("The date contains characters.");
            return;
        }
        Date dob = new Date(strDate);
        Profile profile = new Profile(fname, lname, dob);
        String strHomeStudio = tokens.nextToken().toUpperCase();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        Date expire = calendarToDate(cal);
        if (!Location.tryLocation(strHomeStudio)) {
            System.out.println(strHomeStudio + ": invalid studio location!");
            return;
        }
        if (!dob.isValid()) {
            System.out.println("DOB " + dob + ": invalid calendar date!");
            return;
        }
        if (!profile.validDOB() && dob.isValid()) {
            System.out.println("DOB " + dob + ": must be 18 or older to join!");
            return;
        }
        Location homeStudio = Location.valueOf(strHomeStudio);
        Basic newBasic = new Basic(profile, expire, homeStudio);
        if (this.list.add(newBasic)) {
            System.out.println(fname + " " + lname + " added.");
        } else {
            System.out.println(fname + " " + lname + " is already in the member database.");
        }
    }

    private void parseAF(StringTokenizer tokens) {
        if (tokens.countTokens() < 4) {
            System.out.println("Missing data tokens.");
            return;
        }
        String fname = tokens.nextToken();
        String lname = tokens.nextToken();
        String strDate = tokens.nextToken();
        if (!Date.tryDate(strDate)) {
            System.out.println("The date contains characters.");
            return;
        }
        Date dob = new Date(strDate);
        Profile profile = new Profile(fname, lname, dob);
        String strHomeStudio = tokens.nextToken().toUpperCase();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        Date expire = calendarToDate(cal);
        if (!Location.tryLocation(strHomeStudio)) {
            System.out.println(strHomeStudio + ": invalid studio location!");
            return;
        }
        if (!dob.isValid()) {
            System.out.println("DOB " + dob + ": invalid calendar date!");
            return;
        }
        if (!profile.validDOB() && dob.isValid()) {
            System.out.println("DOB " + dob + ": must be 18 or older to join!");
            return;
        }
        Location homeStudio = Location.valueOf(strHomeStudio);
        Family newFamily = new Family(profile, expire, homeStudio);
        if (this.list.add(newFamily)) {
            System.out.println(fname + " " + lname + " added.");
        } else {
            System.out.println(fname + " " + lname + " is already in the member database.");
        }
    }

    private void parseAP(StringTokenizer tokens) {
        if (tokens.countTokens() < 4) {
            System.out.println("Missing data tokens.");
            return;
        }
        String fname = tokens.nextToken();
        String lname = tokens.nextToken();
        String strDate = tokens.nextToken();
        if (!Date.tryDate(strDate)) {
            System.out.println("The date contains characters.");
            return;
        }
        Date dob = new Date(strDate);
        Profile profile = new Profile(fname, lname, dob);
        String strHomeStudio = tokens.nextToken().toUpperCase();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 11);
        Date expire = calendarToDate(cal);
        if (!Location.tryLocation(strHomeStudio)) {
            System.out.println(strHomeStudio + ": invalid studio location!");
            return;
        }
        if (!dob.isValid()) {
            System.out.println("DOB " + dob + ": invalid calendar date!");
            return;
        }
        if (!profile.validDOB() && dob.isValid()) {
            System.out.println("DOB " + dob + ": must be 18 or older to join!");
            return;
        }
        Location homeStudio = Location.valueOf(strHomeStudio);
        Premium newPremium = new Premium(profile, expire, homeStudio);
        if (this.list.add(newPremium)) {
            System.out.println(fname + " " + lname + " added.");
        } else {
            System.out.println(fname + " " + lname + " is already in the member database.");
        }
    }

    private void parseC(StringTokenizer tokens) {
        if (tokens.countTokens() < 3) {
            System.out.println("Missing data tokens.");
        } else {
            String fname = tokens.nextToken();
            String lname = tokens.nextToken();
            String strDate = tokens.nextToken();
            if (!Date.tryDate(strDate)) {
                System.out.println("The date contains characters.");
                return;
            }
            Date dob = new Date(strDate);

            Profile profile = new Profile(fname, lname, dob);

            Member dummyMember = new Member(profile);
            if (this.list.remove(dummyMember)) {
                System.out.println(fname + " " + lname + " removed.");
            } else {
                System.out.println(fname + " " + lname + " is not in the member database.");
            }
        }
    }

    public void parseR(StringTokenizer tokens) {
        String strOffer = tokens.nextToken().toUpperCase();
        String strInstructor = tokens.nextToken();
        String strLocation = tokens.nextToken().toUpperCase();
        String fname = tokens.nextToken();
        String lname = tokens.nextToken();
        Date dob = new Date(tokens.nextToken());
        Profile profile = new Profile(fname, lname, dob);

        Member dummyMember = new Member(profile, dob, Location.EDISON);

        if (!Offer.tryOffer(strOffer)) {
            System.out.println(strOffer + " - class name does not exist.");
            return;
        }
        Offer offer = Offer.valueOf(strOffer);
        if (!Location.tryLocation(strLocation)) {
            System.out.println(strLocation + " - invalid studio location.");
            return;
        }
        if (!Instructor.tryInstructor(strInstructor)) {
            System.out.println(strInstructor + " - instructor does not exist.");
            return;
        }
        Instructor instructor = Instructor.valueOf(strInstructor);
        if (this.schedule.validClassStudio(location, offer, instructor)) {
            System.out.println(offer + " by " + instructor + " does not exist at" +
                    location);
            return;
        }
        Location location = Location.valueOf(strLocation);
        if (!this.list.foundProfile(profile)) {
            System.out.println(fname + " " + lname + " " + dob + " is not in the member database.");
            return;
        }
        int index = this.list.findProfileIndex(profile);
        Member member = this.list.getMembers()[index];
        if (member.expired()) {
            System.out.println(fname + " " + lname + " " + member.getExpire() + " membership expired.");
        }

        if(schedule.findClassTime(instructor, offer) == null){
            
        }

        if (member.getHomeStudio() != location) {
            System.out.println(fname + " " + lname + " is attending a class at " + location +
                    " - [BASIC] home studio at " + member.getHomeStudio());
        }






    }




}
