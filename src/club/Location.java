package club;

/**
 * An enum class that contains the 5 different locations that the fitness clubs are located at.
 *
 * @author George W Nakhla
 */
public enum Location {

    Bridgewater, Edison, Franklin, Piscataway, Somerville;


    /**
     * A public method that provides a string representation
     * for the zip code for the associated location.
     *
     * @return String representation of the zip code
     */
    public String getZipCode() {
        if (this == Location.Bridgewater) return "08807";
        if (this == Location.Edison) return "08873";
        if (this == Location.Franklin) return "08873";
        if (this == Location.Piscataway) return "08854";
        return "08876";
    }

    /**
     * A public method that provides a string representation
     * for the County for the associated location.
     *
     * @return String representation of the County
     */
    public String getCounty() {
        if (this == Location.Bridgewater || this == Location.Franklin ||
                this == Location.Somerville) return " SOMERSET";
        return "MIDDLESEX";
    }
}
