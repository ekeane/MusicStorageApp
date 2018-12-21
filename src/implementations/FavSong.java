package implementations;

import java.util.List;

public class FavSong extends Song {

    private int rating;
    private int songLength;
    private String favSongSymbol;

    public FavSong(String title, String artist, String albumName, int rating, int songLength) {
        super(title, artist, albumName);
        this.rating = rating;
        this.songLength = songLength;
        this.favSongSymbol = "⭐";

    }


    // getters
    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public int getsongLength() {
        return songLength;
    }


    @Override
    public String getfavSongSymbol() {   // Source: https://emojipedia.org/white-medium-star/
        return favSongSymbol;
    }
}


