package implementations;

import java.util.List;

public class RegularSong extends Song {


    public RegularSong(String title, String artist, String albumName) {
        super(title, artist, albumName);

    }

    // getters
    @Override
    public int getRating() {
        System.out.println("Regular songs do not have ratings, only favourite songs do!");
        return 0;
    }

    @Override
    public int getsongLength() {
        System.out.println("Regular songs do not have a song length, only favourite songs do!");
        return 0;
    }

    @Override
    public String getfavSongSymbol() {
        return null;
    }

}
