package mediademo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Jamal Kamareddine
 *
 * This program reads media info from a text file and allows the user to search through the media and add to it
 */
public class MediaDemo {
    Scanner keyboard = new Scanner(System.in);
    ArrayList<Media> catalog = new ArrayList<Media>();
    String fileName = "catalog2.txt";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        MediaDemo myHelper = new MediaDemo();
        System.out.println("Welcome to the media catalog.");
        System.out.println();
        
        myHelper.readFile();
        myHelper.displayMenu();
    }
    
    /**
     * Read the text file and assign each variable to its corresponding media info
     */
    public void readFile() throws FileNotFoundException {
        File myFile = new File(fileName);
        Scanner inputFile = new Scanner(myFile);
        CDMedia myCDMedia;
        DVDMedia myDVDMedia;
        String mediaType;
        String artistName;
        String mediaName;
        String albumSongs;
        String movieCostars;
        int year = 0;
        ArrayList<String> songs;
        ArrayList<String> costars;
        
        // Read through the file of media
        while (inputFile.hasNext()) {
            mediaType = inputFile.next();
            
            // Assign the media info for a CD
            if (mediaType.equalsIgnoreCase("c")) {
                artistName = inputFile.next();
                mediaName = inputFile.next();
                albumSongs = inputFile.nextLine();
                songs = new ArrayList<String>();
                songs.add(albumSongs);

                // Create a CD media object and add it to the media catalog
                myCDMedia = new CDMedia(mediaType, artistName, mediaName, songs);
                catalog.add(myCDMedia);
            }
            
            // Assign the media info for a DVD
            if (mediaType.equalsIgnoreCase("d")) {
                artistName = inputFile.next();
                mediaName = inputFile.next();

                while (inputFile.hasNextInt()) {
                    year = inputFile.nextInt();
                }
                movieCostars = inputFile.nextLine();
                costars = new ArrayList<String>();
                costars.add(movieCostars);

                // Create a DVD media object and add it to the media catalog
                myDVDMedia = new DVDMedia(mediaType, artistName, mediaName, year, costars);
                catalog.add(myDVDMedia);
            }  
        }
    }
    
    /**
     * Display the menu of options to the user
     */
    public void displayMenu() throws IOException {
        int selection = 4;
        
        // Loop the menu of options
        do {
            System.out.println("What would you like to do?" + "\n" +
                               "1. Search by Media Title (movie name or album name)" + "\n" +
                               "2. Search by Artist (singer or actor/actress)" + "\n" +
                               "3. Add media to catalog" + "\n" +
                               "4. Quit");
            selection = keyboard.nextInt();
            keyboard.nextLine();
        
            switch (selection) {
                case 1:
                    mediaSearch();
                    break;
                case 2:
                    artistSearch();
                    break;
                case 3:
                    addMedia();
                    break;
                case 4:
                    System.out.println("Thank you for using the media catalog.");
                    break;
                default:
                    System.out.println("Sorry, you entered an invalid option. Please try again." + "\n");
            }
        } while(selection != 4);
    }
    
    /**
     * Sort the media by their media name
     */
    public void sortByMediaName() {
        Collections.sort(catalog);
    }
    
    /**
     * Sort the media by their artist name
     */
    public void sortByArtistName() {
        Collections.sort(catalog, new MediaComparatorByArtistName());
    }
    
    /**
     * Search through the arraylist for media by its media name
     */
    public void mediaSearch() {
        System.out.println("Enter the name of the media and place an underscore wherever there is a space. Example: toy_story");
        String userSearch = keyboard.next();
        
        // Create a search object containing only the media name entered by the user
        Media searchObject = new Media(null, null, userSearch);
        sortByMediaName();
        int index = Collections.binarySearch(catalog, searchObject, null);
        
        if (index < 0) {
            System.out.println("Media not found." + "\n");
        }
        else {
            System.out.println(catalog.get(index));
        }
    }
    
    /**
     * Search through the arraylist for media by its artist name
     */
    public void artistSearch() {
        System.out.println("Enter the name of the artist and place an underscore wherever there is a space. Example: kanye_west");
        String userSearch = keyboard.next();
        
        // Create a search object containing only the artist name entered by the user
        Media searchObject = new Media(null, userSearch, null);
        sortByArtistName();
        int index = Collections.binarySearch(catalog, searchObject, new MediaComparatorByArtistName());
        
        if (index < 0) {
            System.out.println("Artist not found." + "\n");
        }
        else {
            System.out.println(catalog.get(index));
        }
    }
    
    /**
     * Add media entered by the user to the text file
     */
    public void addMedia() throws FileNotFoundException, IOException {
        // Open the file and allow text to be added to the end of the file
        File myFile = new File(fileName);
        FileWriter writeFile = new FileWriter(myFile, true);
        PrintWriter output = new PrintWriter(writeFile);
        
        CDMedia myCDMedia;
        DVDMedia myDVDMedia;
        String userInput = "";
        
        // Ask the user for the media type they want to add
        System.out.println("What type of media would you like to add? Type C for CD or D for DVD.");
        String mediaType = keyboard.next();
        output.print(mediaType);
        output.print(" ");
        
        // Add a CD media to the text file
        if (mediaType.equalsIgnoreCase("C")) {
            ArrayList<String> songs = new ArrayList<String>();
            
            System.out.println("Enter the name of the artist. Place an underscore wherever there is a space. Example: kanye_west");
            String artistName = keyboard.next();
            output.print(artistName);
            output.print(" ");
            
            System.out.println("Enter the name of the CD. Place an underscore wherever there is a space.");
            String mediaName = keyboard.next();
            output.print(mediaName);
            output.print(" ");
            
            // Loop to add songs to the media
            do {
                System.out.println("Enter the name of each song one by one and place an underscore wherever there is a space.");
                String albumSongs = keyboard.next();
                songs.add(albumSongs);
                output.print(albumSongs);
                output.print(" ");
                
                System.out.println("Are there any more songs? Type YES or NO.");
                userInput = keyboard.next();
                
            } while (userInput.equalsIgnoreCase("yes"));
            output.println();
            
            // Create a CD media object from the info entered by the user
            myCDMedia = new CDMedia(mediaType, artistName, mediaName, songs);
            catalog.add(myCDMedia);
            output.close();
            System.out.println("Media successfully added.");
        }
        // Add a DVD media to the text file
        else if (mediaType.equalsIgnoreCase("D")) {
            ArrayList<String> costars = new ArrayList<String>();
            
            System.out.println("Enter the name of the lead actor/actress. Place an underscore wherever there is a space. Example: keanu_reeves");
            String artistName = keyboard.next();
            output.print(artistName);
            output.print(" ");
            
            System.out.println("Enter the name of the the DVD. Place an underscore wherever there is a space.");
            String mediaName = keyboard.next();
            output.print(mediaName);
            output.print(" ");
            
            System.out.println("Enter the year of the DVD.");
            int year = keyboard.nextInt();
            keyboard.nextLine();
            output.print(year);
            output.print(" ");
            
            // Loop to add co-stars to the media
            do {
                System.out.println("Enter the name of each co-star one by one and place an underscore wherever there is a space.");
                String movieCostars = keyboard.next();
                costars.add(movieCostars);
                output.print(movieCostars);
                output.print(" ");
                
                System.out.println("Are there any more co-stars? Type YES or NO.");
                userInput = keyboard.next();
                
            } while (userInput.equalsIgnoreCase("yes"));
            output.println();
            
            // Create a DVD media object from the info entered by the user
            myDVDMedia = new DVDMedia(mediaType, artistName, mediaName, year, costars);
            catalog.add(myDVDMedia);
            output.close();
            System.out.println("Media successfully added.");
        }
        else {
            System.out.println("Invalid media type.");
        }
    }
}
