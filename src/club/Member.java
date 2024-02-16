package club;

import java.util.Date;

/**
 * This class represents a current Member of the fitness club.
 *
 * @author George W Nakhla
 */
public class Member implements Comparable<Member> {
    private Profile profile;
    private Date expire;
    private Location homeStudio;

    /**
     * Default constructor for the Member class.
     */
    public Member() {

    }

    /**
     * Parameterized constructor for the Member class.
     *
     * @param profile    The profile information of the member.
     * @param expire     The expiration date of the membership.
     * @param homeStudio The location of the member's home studio.
     */
    public Member(Profile profile, Date expire, Location homeStudio) {
        this.profile = profile;
        this.expire = expire;
        this.homeStudio = homeStudio;
    }

    /**
     * Calculates and returns the next due amount for the membership.
     *
     * @return The next due amount for the membership.
     */
    public double bill() {
        // work on this later
        return 0.0;
    }

    /**
     * Compares this Member object with another Member object for order.
     *
     * @param member The Member object to compare with.
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Member member) {
        if (!this.profile.equals(member.profile)) {
            return this.profile.compareTo(member.profile);
        }
        if (!this.expire.equals(member.expire)) {
            return this.expire.compareTo(member.expire);
        }
        return this.homeStudio.compareTo(member.homeStudio);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param member The Member object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Member member) {
        if (!this.profile.equals(member.profile)) {
            return false;
        }
        if (!this.expire.equals(member.expire)) {
            return false;
        }
        return this.homeStudio.equals(member.homeStudio);
    }

    /**
     * Returns a string representation of the Member object.
     *
     * @return A string representation of the Member object.
     */
    public String toString() {
        return this.profile.toString() + ", Membership expires " +
                this.expire.toString() + ", Location: " +
                this.homeStudio.toString().toUpperCase() + ", " + this.homeStudio.getZipCode() + ", " +
                this.homeStudio.getCounty();
    }
}
