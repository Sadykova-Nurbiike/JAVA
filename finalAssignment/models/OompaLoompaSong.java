package models;


import java.util.Random;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class OompaLoompaSong {

    //Attributes
    private ArrayList<String> linesOfSong;

    //Constructors:
    //Constructor with arguments
    public OompaLoompaSong() {
        linesOfSong = new ArrayList<String>();
    }

    //Constructor with arguments	
    public OompaLoompaSong(int lines) throws FileNotFoundException {
        //reading lines of song to arraylist from file
        Random random = new Random();

        ArrayList<String> linesFromFile = new ArrayList<String>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("OompaLoompaSong.txt")));
        while (sc.hasNextLine()) {
            linesFromFile.add(sc.nextLine());
        }
        sc.close();

        //Creating OompaLoompaSong
        linesOfSong = new ArrayList<String>();
        for (int i = 0; i < lines; i++) {
            linesOfSong.add(linesFromFile.get(random.nextInt(23)));
        }
    }

    // Return a String with the song
    public String sing() {
        String lines = "";
        for (String line : linesOfSong) {
            lines = lines + "\n" + line;
        }
        return lines;
    }
}
