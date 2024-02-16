package club;

/**
 * An enum class that contains the 5 different locations that the fitness clubs are located at.
 *
 * @author George W Nakhla
 */
public enum Location {

    bridgewater, edison, franklin, piscataway, somerville;


    /**
     * A public method that provides a string representation
     * for the zip code for the associated location.
     *
     * @return String representation of the zip code
     */
    public String getZipCode() {
        if (this == Location.bridgewater) return "08807";
        if (this == Location.edison) return "08873";
        if (this == Location.franklin) return "08873";
        if (this == Location.piscataway) return "08854";
        return "08876";
    }

    /**
     * A public method that provides a string representation
     * for the County for the associated location.
     *
     * @return String representation of the County
     */
    public String getCounty() {
        if (this == Location.bridgewater || this == Location.franklin ||
                this == Location.somerville) return " SOMERSET";
        return "MIDDLESEX";
    }
}
