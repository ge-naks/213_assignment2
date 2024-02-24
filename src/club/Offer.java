package club;

public enum Offer {
    CARDIO, PILATES, SPINNING;

    public static boolean tryOffer(String offer){
        try {
            Location.valueOf(offer);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }



}
