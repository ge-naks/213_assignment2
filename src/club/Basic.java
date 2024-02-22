package club;


public class Basic extends Member {
    private int numClasses;

    public Basic(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        numClasses = 0;
    }
    // getter
    public int getNumClasses() {
        return numClasses;
    }

    public void attendClasses() {
        numClasses++;
    }
    @Override
    public double bill() {
        final double BASE_FEE = 39.99;
        final int EXTRA_CLASS_FEE = 10;
        double totalBasicFee = BASE_FEE;
        if (numClasses > 4) {
            totalBasicFee += (numClasses - 4) * EXTRA_CLASS_FEE;
        }
        return totalBasicFee;
    }
}
