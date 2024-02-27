package club;

public class Premium extends Member{
    private int guestPass;


    public Premium(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
    }

    public int getPassOutstanding(){
        return this.guestPass;
    }


    public boolean hasMorePass(){
        final int MAX_GUESTS = 3;
        return this.guestPass < 3;
    }

    public boolean addGuest(){
        final int MAX_GUESTS = 3;
        if(this.guestPass < MAX_GUESTS){
        this.guestPass++;
            return true;
        }
        return false;
    }

    public boolean removeGuest(){
        final int NO_GUESTS = 0;
        if(this.guestPass == NO_GUESTS) return false;
        this.guestPass--;
        return true;
    }


public String guestStatus(){
    final int MAX_GUESTS = 3;
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
        final int MAX_GUESTS = 3;
        String membershipType;
        if (!expired()) {
            membershipType = "(Premium) guest-pass remaining: ";
            if (guestPass == MAX_GUESTS) {
                membershipType += "0";
                return super.toString() + " " + membershipType;
            } else {
                membershipType += (MAX_GUESTS - guestPass);
                return super.toString() + " " + membershipType;
            }
        } else {
            membershipType = "(Premium) guest-pass remaining: not eligible";
            return super.toString() + ", " + membershipType;
        }

    }
}
