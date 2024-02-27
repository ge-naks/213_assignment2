package club;

public class FitnessClass {
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
        this.members = new MemberList(); // Initialize members list
        this.guests = new MemberList();  // Initialize guests list
    }


    public Offer getClassInfo() {
        return classInfo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Time getTime() {
        return time;
    }

    public MemberList getGuests() {
        return guests;
    }

    public MemberList getMembers() {
        return members;
    }

    public Location getStudio() {
        return studio;
    }

    public boolean addMember(Member member){
        return this.members.add(member);

    }

    public boolean removeMember(Member member){
        return this.members.remove(member);
    }


    public boolean addGuest(Member member){
        return this.guests.forceAdd(member);

    }

    public boolean removeGuest(Member member){
        return this.guests.remove(member);
    }


    @Override
    public String toString() {
        String strName = this.studio.name();
        return this.classInfo + " - " + this.instructor.toString().toUpperCase() + ", " + this.time.getTime() + ", "
                + this.studio.name();
    }

}
