package test;

import implementations.FavSong;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FavSongTest { // reference: Data Abstraction Solutions/Friend Net Master

    private FavSong s1;
    private FavSong s2;
    private FavSong s3;
    private FavSong s4;

    @Before
    public void songSetter() {
        s1 = new FavSong("Come as you are", "Nirvana", "In Bloom", 7, 3);
        s2 = new FavSong("Time to Pretend", "MGMT", "Orangular Spectacular", 8, 2);
        s3 = new FavSong("Mob Ties", "Drake", "Scorpion", 9, 4);
        s4 = new FavSong("Goosebumps", "Travis Scott", "Birds in the Trap Sing McKight", 6, 5);

    }

    @Test
    public void gettertest() {
        assertEquals(s1.getTitle(), "Come as you are");
        assertEquals(s1.getArtist(), "Nirvana");
        assertEquals(s1.getAlbumName(), "In Bloom");
        assertEquals(s1.getRating(), 7);
        assertEquals(s1.getsongLength(), 3);
        assertEquals(s1.getfavSongSymbol(), "⭐");

        assertEquals(s2.getTitle(), "Time to Pretend");
        assertEquals(s2.getArtist(), "MGMT");
        assertEquals(s2.getAlbumName(), "Orangular Spectacular");
        assertEquals(s2.getRating(), 8);
        assertEquals(s2.getsongLength(), 2);
        assertEquals(s2.getfavSongSymbol(), "⭐");

        assertEquals(s3.getTitle(), "Mob Ties");
        assertEquals(s3.getArtist(), "Drake");
        assertEquals(s3.getAlbumName(), "Scorpion");
        assertEquals(s3.getRating(), 9);
        assertEquals(s3.getsongLength(), 4);
        assertEquals(s3.getfavSongSymbol(), "⭐");

        assertEquals(s4.getTitle(), "Goosebumps");
        assertEquals(s4.getArtist(), "Travis Scott");
        assertEquals(s4.getAlbumName(), "Birds in the Trap Sing McKight");
        assertEquals(s4.getRating(), 6);
        assertEquals(s4.getsongLength(), 5);
        assertEquals(s4.getfavSongSymbol(), "⭐");
    }

}
