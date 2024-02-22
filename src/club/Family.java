package club;

public class Family extends Member {
    private boolean guest;

    public Family(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);

    }
    @Override
    public double bill() {
        final double BASE_FEE = 49.99;
        final int EXTRA_CLASS_FEE = 10;
        double totalBasicFee = BASE_FEE;
        if (numClasses > 4) {
            totalBasicFee += numClasses - 4 * EXTRA_CLASS_FEE;
        }
        return totalBasicFee;
    }
}