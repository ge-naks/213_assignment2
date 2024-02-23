package club;

public class Premium extends Member {
    private int guestPass;
    private static final int GUEST_PASS_LIMIT = 3;

    public Premium(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        guestPass = GUEST_PASS_LIMIT;
    }

    public int getGuestPass() {
        return guestPass;
    }

    public void useGuestPass() {
        if (guestPass > 0) {
            guestPass--;
        }
    }

    @Override
    public double bill() {
        // Monthly fee for Premium membership
        double PREMIUM_FEE = 59.99;
        // Total fee for 12 months
        double totalFee = PREMIUM_FEE * 12;
        // Subtracting the fee for one month (one month free)
        totalFee -= monthlyFee;
        return totalFee;
    }
}
