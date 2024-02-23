package club;

public class Family extends Member {
    private boolean guest;

    public Family(Profile profile, Date expire, Location homeStudio, boolean guestPass) {
        super(profile, expire, homeStudio);
        guest = true;
    }

    public boolean hasGuestPass() {
        return guest;
    }

    public void guestPassUsed() {
        if (guest) {
            guest = false;
        }
    }

    @Override
    public double bill() {
        // Monthly billing for Family membership
        double monthlyFee = 49.99;
        // Billable every 3 months
        return monthlyFee * 3;
    }
}