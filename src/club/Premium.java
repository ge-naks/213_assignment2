package club;

public class Premium extends Member{
    private int guestPass;

    public Premium(Profile profile, Date expire, Location homeStudio, int guestPass) {
        super(profile, expire, homeStudio);
        this.guestPass = guestPass;
    }

    public int getPassOutstanding(){
        return this.guestPass;
    }

    public boolean hasMorePass(){
        return this.guestPass > 0;
    }



    @Override
    public double bill() {
        final double PREMIUM_FEE = 59.99;
        return PREMIUM_FEE;
    }
}
