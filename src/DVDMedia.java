package mediademo;

import java.util.ArrayList;

/**
 * @author Jamal Kamareddine
 *
 * This program holds data about DVD media
 */
public class DVDMedia extends Media {
    private int year;
    private ArrayList<String> costars;
    
    /**
     * Constructor to set each parameter
     * 
     * @param anArtistName
     * @param aMediaName
     * @param aYear
     * @param movieCostars
     */
    public DVDMedia(String aMediaType, String anArtistName, String aMediaName, int aYear, ArrayList<String> movieCostars) {
        super(aMediaType, anArtistName, aMediaName);
        this.year = aYear;
        costars = new ArrayList<String>(movieCostars);
    }
    
    /**
     * @return The year of the movie
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Sets the year of the movie
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return The costars of the movie
     */
    public ArrayList<String> getCostars() {
        return costars;
    }
    
    /**
     * Sets the costars for the movie
     */
    public void setCostars(ArrayList<String> costars) {
        this.costars = new ArrayList<String>(costars);
    }
    
    /**
     * @return The DVD media information
     */
    public String toString() {
        String str = super.toString() + "\n"
                + "Year = " + year + "\n"
                + "Co-stars = " + costars + "\n";
        
        return str;
    }
}
