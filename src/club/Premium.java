package club;

public class Premium extends Member{
    private int guestPass;
    private final int MAX_GUESTS = 3;

    public Premium(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
    }

    public int getPassOutstanding(){
        return this.guestPass;
    }


    public boolean addGuest(){
        if(this.guestPass >= MAX_GUESTS) return false;
        guestPass++;
        return true;
    }

    public boolean removeGuest(){
        final int NO_GUESTS = 0;
        if(this.guestPass == NO_GUESTS) return false;
        guestPass--;
        return true;
    }


public String guestStatus(){
        return Integer.toString(MAX_GUESTS - this.guestPass);
}

    @Override
    public double bill() {
        // billed annually for 11 mos
        final int NUM_MONTHS = 11;
        final double PREMIUM_FEE = 59.99;
        return PREMIUM_FEE * NUM_MONTHS;
    }
    public String toString() {
        String membershipType;
        if (!expired()) {
            membershipType = "(Premium) guest-pass remaining: ";
            if (guestPass == MAX_GUESTS) {
                membershipType += "0";
            } else {
                membershipType += (MAX_GUESTS - guestPass);
            }
        } else {
            membershipType = "(Premium) guest-pass remaining: not eligible";
        }
        return super.toString() + ", " + membershipType;
    }
}
