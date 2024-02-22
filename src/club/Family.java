package club;

public class Family extends Member {
    private boolean guest;

    public Family(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);

    }
    @Override
    public double bill() {
        final double FAMILY_FEE = 49.99;
        return FAMILY_FEE;
    }
}