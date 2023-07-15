package mediademo;

/**
 * @author Jamal Kamareddine
 *
 * This program holds general data about a type of media
 */
public class Media implements Comparable {
    private String mediaType;
    private String artistName;
    private String mediaName;
    
    /**
     * Constructor to set each parameter
     * 
     * @param aMediaType The type of media
     * @param anArtistName The name of the artist
     * @param aMediaName The name of the media
     */
    public Media(String aMediaType, String anArtistName, String aMediaName) {
        this.mediaType = aMediaType;
        this.artistName = anArtistName;
        this.mediaName = aMediaName;
    }
    
    /**
     * Constructor to the parameter
     * 
     * @param userSearch A search term entered by the user
     */
    public Media(String userSearch) {
        this.userSearch = userSearch;
    }

    /**
     * @return The type of media
     */
    public String getMediaType() {
        return mediaType;
    }
    
    /**
     * Sets the media type
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    
    /**
     * @return The name of the artist
     */
    public String getArtistName() {
        return artistName;
    }
    
    /**
     * Sets the name of the artist
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    
    /**
     * @return The name of the media
     */
    public String getMediaName() {
        return mediaName;
    }
    
    /**
     * Sets the name of the media
     */
    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }
    
    /**
     * @return The media information
     */
    public String toString() {
        String str = "Media Type = " + mediaType + "\n"
                    + "Artist = " + artistName + "\n"
                    + "Media Title = " + mediaName;
                
        return str;
    }
    
    /**
     * Compares two media objects by their media name and sorts them
     * 
     * @param other Another media object
     * 
     * @return The media in alphabetical order by their media name
     */
    @Override
    public int compareTo(Object other) {
        Media otherMedia = (Media) other;
        return this.mediaName.compareTo(otherMedia.mediaName);
    }
}
