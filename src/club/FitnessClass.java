package club;

public class FitnessClass{
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

    public MemberList getGuests() {
        return guests;
    }

    public Time getTime() {
        return time;
    }

    public MemberList getMembers() {
        return members;
    }

    public Location getStudio() {
        return studio;
    }


}
