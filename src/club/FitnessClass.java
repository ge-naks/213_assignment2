package club;

public class FitnessClass implements Comparable<FitnessClass> {
    private Offer classInfo;
    private Instructor instructor;
    private Location studio;
    private Time time;
    private MemberList members;
    private MemberList guests;

    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time) {
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;
        this.time = time;
    }

    public Offer getClassInfo() {
        return classInfo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Location getStudio() {
        return studio;
    }

    @Override
    public String toString(){
        return  this.classInfo + " - " + this.instructor + ", " + this.time + ", "
                + this.studio;
    }

    public boolean equals(){
        return true;
    }

    public int compareTo(FitnessClass fitnessClass){
        return 0;
    }


}
