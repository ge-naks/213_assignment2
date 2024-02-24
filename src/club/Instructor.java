package club;

public enum Instructor {
    Davis, Denise, Emma, Jennifer, Kim;


    public static boolean tryInstructor(String instructor){
        try {
            Location.valueOf(instructor);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
