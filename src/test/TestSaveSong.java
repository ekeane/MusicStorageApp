package test;

import implementations.FavSong;
import implementations.MusicPlayer;
import implementations.MusicPlayerSaveLoad;
import implementations.RegularSong;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;


public class TestSaveSong {

    private MusicPlayerSaveLoad mpsl;
    private MusicPlayer mp1;

    private RegularSong s1;
    private RegularSong s2;
    private RegularSong s3;
    private RegularSong s4;

    private FavSong s5;
    private FavSong s6;

    @Before
    public void songSetter() {
        s1 = new RegularSong("Come as you are", "Nirvana", "In Bloom");
        s2 = new RegularSong("Time to Pretend", "MGMT", "Orangular Spectacular");
        s3 = new RegularSong("Mob Ties", "Drake", "Scorpion");
        s4 = new RegularSong("Goosebumps", "Travis Scott", "Birds in the Trap Sing McKight");

        s5 = new FavSong("Talk a walk", "Passion Pit", "Walk", 8, 3);
        s6 = new FavSong("Walk it Like I talk it", "Migos feat. Drake", "Culture II", 10, 4);

        mp1 = new MusicPlayer();
        mpsl = new MusicPlayerSaveLoad(mp1);

    }

    @Test
    public void testsave() throws IOException {

        mp1.addSong(s1);
        mp1.addSong(s2);
        mp1.addSong(s3);

        mp1.addSong(s5);
        mp1.addSong(s6);

        mpsl.save("eamonn");


        assertFalse(mp1.getSongList().contains(s4));
        assertTrue(mp1.getSongList().contains(s1));
        assertTrue(mp1.getSongList().contains(s2));
        assertTrue(mp1.getSongList().contains(s3));
        assertTrue(mp1.getSongList().contains(s5));
        assertTrue(mp1.getSongList().contains(s6));

    }


    @Test
    public void testconvertObjectArray() {

        mp1.addSong(s1);
        mp1.addSong(s2);
        mp1.addSong(s3);

        mp1.addSong(s5);
        mp1.addSong(s6);

       ArrayList<String> songToString =  mpsl.convertObjectArray();

        assertFalse(songToString.contains("Title: Goosebumps, Artist: Travis Scott, Album Name: Birds in the Trap Sing McKight"));
        assertTrue(songToString.contains("Title: Come as you are, Artist: Nirvana, Album Name: In Bloom"));
        assertTrue(songToString.contains("Title: Time to Pretend, Artist: MGMT, Album Name: Orangular Spectacular"));
        assertTrue(songToString.contains("Title: Mob Ties, Artist: Drake, Album Name: Scorpion"));
        assertTrue(songToString.contains("⭐ Title: Talk a walk, Artist: Passion Pit, Album Name: Walk"));
        assertTrue(songToString.contains("⭐ Title: Walk it Like I talk it, Artist: Migos feat. Drake, Album Name: Culture II"));


    }


}
