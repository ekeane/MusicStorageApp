package test;

import exceptions.NonNumberInputException;
import implementations.MusicPlayer;
import implementations.Playlist;
import implementations.RegularSong;
import implementations.Song;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MusicPlayerTest {

    private MusicPlayer eamonnMusicPlayer;

    private RegularSong s1;
    private RegularSong s2;
    private RegularSong s3;
    private RegularSong s4;

    private Playlist p1;
    private Playlist p2;

    private List<Song> los1;
    private List<Song> los2;

    @Before
    public void songSetter() {

        eamonnMusicPlayer = new MusicPlayer();

        s1 = new RegularSong("Come as you are", "Nirvana", "In Bloom");
        s2 = new RegularSong("Time to Pretend", "MGMT", "Orangular Spectacular");
        s3 = new RegularSong("Mob Ties", "Drake", "Scorpion");
        s4 = new RegularSong("Goosebumps", "Travis Scott", "Birds in the Trap Sing McKight");

        los1 = new ArrayList<>();
        los2 = new ArrayList<>();

        los1.add(s1);
        los1.add(s2);

        los2.add(s3);
        los2.add(s4);

        p1 = new Playlist("Rap", "Eamonn", los2);

        p2 = new Playlist("CLassics", "Connor", los1);




    }

    @Test
    public void testaddSong() {

        eamonnMusicPlayer.addSong(s1);
        eamonnMusicPlayer.addSong(s2);
        eamonnMusicPlayer.addSong(s3);
        eamonnMusicPlayer.addSong(s4);

        assertTrue(eamonnMusicPlayer.getSongList().contains(s1));
        assertTrue(eamonnMusicPlayer.getSongList().contains(s2));
        assertTrue(eamonnMusicPlayer.getSongList().contains(s3));

        eamonnMusicPlayer.getSongList().remove(s1);
        eamonnMusicPlayer.getSongList().remove(s3);

        assertFalse(eamonnMusicPlayer.getSongList().contains(s1));
        assertFalse(eamonnMusicPlayer.getSongList().contains(s3));

    }


    @Test
    public void testAddPlaylist() {
        eamonnMusicPlayer.addPlaylist(p1);
        assertTrue(eamonnMusicPlayer.getPlaylists().contains(p1));
    }

    @Test
    public void testprintPlaylistSongs() {
        eamonnMusicPlayer.addPlaylist(p1);

    }


    @Test
    public void testprintSongList() {

        eamonnMusicPlayer.addSong(s1);
        eamonnMusicPlayer.addSong(s2);
        eamonnMusicPlayer.addSong(s3);
        eamonnMusicPlayer.addSong(s4);

        assertTrue(eamonnMusicPlayer.getSongList().size() > 0);

        eamonnMusicPlayer.getSongList().remove(s1);
        eamonnMusicPlayer.getSongList().remove(s2);
        eamonnMusicPlayer.getSongList().remove(s3);
        eamonnMusicPlayer.getSongList().remove(s4);

        assertFalse(eamonnMusicPlayer.getSongList().size() > 0);

        eamonnMusicPlayer.addSong(s1);
        eamonnMusicPlayer.addSong(s2);
        eamonnMusicPlayer.addSong(s3);


        assertEquals(s1.getTitle() + " by " + s1.getArtist(), "Come as you are by Nirvana");
        assertEquals(s2.getTitle() + " by " + s2.getArtist(), "Time to Pretend by MGMT");
        assertEquals(s3.getTitle() + " by " + s3.getArtist(), "Mob Ties by Drake");


    }

    @Test
    public void testremoveSong() {

        eamonnMusicPlayer.addSong(s1);
        eamonnMusicPlayer.addSong(s2);
        eamonnMusicPlayer.addSong(s3);

        assertTrue(eamonnMusicPlayer.getSongList().contains(s1));
        assertTrue(eamonnMusicPlayer.getSongList().contains(s2));
        assertTrue(eamonnMusicPlayer.getSongList().contains(s3));

        assertTrue(eamonnMusicPlayer.removeSong("Come as you are"));
        assertTrue(eamonnMusicPlayer.removeSong("Time to Pretend"));
        assertTrue(eamonnMusicPlayer.removeSong("Mob Ties"));


        assertFalse(eamonnMusicPlayer.getSongList().contains(s1));
        assertFalse(eamonnMusicPlayer.getSongList().contains(s2));
        assertFalse(eamonnMusicPlayer.getSongList().contains(s3));

        assertFalse(eamonnMusicPlayer.removeSong("Come as you are"));
        assertFalse(eamonnMusicPlayer.removeSong("Time to Pretend"));
        assertFalse(eamonnMusicPlayer.removeSong("Mob Ties"));

    }


    // Tests for Exceptions

    @Test
    public void testParseInputTrue() {
        try {
            eamonnMusicPlayer.parseInput("1");
        } catch (NonNumberInputException e) {
            fail("Doesnt reach here!");
        }

    }

    @Test
    public void testParseInputFalse() {
        try {
            eamonnMusicPlayer.parseInput("w");
        } catch (NonNumberInputException e) {
            return;
        }
        fail("Doesn't reach here!");
    }

}
