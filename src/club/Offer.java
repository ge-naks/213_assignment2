package club;

public enum Offer {
    CARDIO, PILATES, SPINNING;

    public static boolean tryOffer(String offer){
        try {
            Offer.valueOf(offer.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }



}
