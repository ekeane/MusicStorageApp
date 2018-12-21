package test;

import implementations.RegularSong;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularSongTest { // reference: Data Abstraction Solutions/Friend Net Master

    private RegularSong s1;
    private RegularSong s2;
    private RegularSong s3;
    private RegularSong s4;

    @Before
    public void songSetter() {
        s1 = new RegularSong("Come as you are", "Nirvana", "In Bloom");
        s2 = new RegularSong("Time to Pretend", "MGMT", "Orangular Spectacular");
        s3 = new RegularSong("Mob Ties", "Drake", "Scorpion");
        s4 = new RegularSong("Goosebumps", "Travis Scott", "Birds in the Trap Sing McKight");

    }

    @Test
    public void gettertest() {
        assertEquals(s1.getTitle(), "Come as you are");
        assertEquals(s1.getArtist(), "Nirvana");
        assertEquals(s1.getAlbumName(), "In Bloom");
        assertEquals(s1.getRating(), 0);
        assertEquals(s1.getsongLength(), 0);
        assertEquals(s1.getfavSongSymbol(), null);



        assertEquals(s2.getTitle(), "Time to Pretend");
        assertEquals(s2.getArtist(), "MGMT");
        assertEquals(s2.getAlbumName(), "Orangular Spectacular");
        assertEquals(s2.getRating(), 0);
        assertEquals(s2.getsongLength(), 0);
        assertEquals(s2.getfavSongSymbol(), null);

        assertEquals(s3.getTitle(), "Mob Ties");
        assertEquals(s3.getArtist(), "Drake");
        assertEquals(s3.getAlbumName(), "Scorpion");
        assertEquals(s3.getRating(), 0);
        assertEquals(s3.getsongLength(), 0);
        assertEquals(s3.getfavSongSymbol(), null);

        assertEquals(s4.getTitle(), "Goosebumps");
        assertEquals(s4.getArtist(), "Travis Scott");
        assertEquals(s4.getAlbumName(), "Birds in the Trap Sing McKight");
        assertEquals(s4.getRating(), 0);
        assertEquals(s4.getsongLength(), 0);
        assertEquals(s4.getfavSongSymbol(), null);
    }

}
