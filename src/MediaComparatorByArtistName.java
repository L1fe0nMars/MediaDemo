package mediademo;

import java.util.Comparator;

/**
 * @author Jamal Kamareddine
 *
 * This program compares media by their artist name
 */
public class MediaComparatorByArtistName implements Comparator<Media> {
    public int compare(Media artist1, Media artist2) {
        return artist1.getArtistName().compareTo(artist2.getArtistName());
    }
}
