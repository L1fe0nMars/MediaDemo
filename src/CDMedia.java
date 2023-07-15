package mediademo;

import java.util.ArrayList;

/**
 * @author Jamal Kamareddine
 *
 * This program holds data about CD media
 */
public class CDMedia extends Media {
    private ArrayList<String> songs;
    
    /**
     * Constructor to set each parameter
     * 
     * @param anArtistName
     * @param aMediaName
     * @param albumSongs
     */
    public CDMedia(String aMediaType, String anArtistName, String aMediaName, ArrayList<String> albumSongs) {
        super(aMediaType, anArtistName, aMediaName);
        songs = new ArrayList<String>(albumSongs);
    }
    
    /**
     * @return All the songs of the album
     */
    public ArrayList<String> getSongs() {
        return songs;
    }
    
    /**
     * Sets all the songs of the album
     */
    public void setSongs(ArrayList<String> songs) {
        this.songs = new ArrayList<String>(songs);
    }
    
    /**
     * @return The CD media information
     */
    public String toString() {
        String str = super.toString() + "\n"
                + "Songs = " + songs + "\n";
        
        return str;
    }
}
