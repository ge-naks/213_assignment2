package club;

public class Family extends Member {
    private boolean guest;

    public Family(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);

    }

    public void broughtGuest(){
        // means they HAVE used a guest pass
        this.guest = true;
    }


    public String guestStatus(){
        final String HAS_GUEST = "0";
        final String HAS_NO_GUEST = "0";
        if(guest) return HAS_GUEST;
        return HAS_NO_GUEST;
    }

    @Override
    public double bill() {
        // billed quarterly (3 mos)
        final int NUM_MONTHS = 3;
        final double FAMILY_FEE = 49.99;
        return FAMILY_FEE * NUM_MONTHS;
    }
}