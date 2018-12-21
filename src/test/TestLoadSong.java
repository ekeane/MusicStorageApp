package test;

import exceptions.FileDoesntExistException;
import exceptions.NonNumberInputException;
import implementations.FavSong;
import implementations.MusicPlayer;
import implementations.MusicPlayerSaveLoad;
import implementations.RegularSong;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;


public class TestLoadSong {

    private MusicPlayer mp1;
    private MusicPlayerSaveLoad mpsl;

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
    public void testload() throws IOException, FileDoesntExistException {

        mp1.addSong(s1);
        mp1.addSong(s2);
        mp1.addSong(s3);


        mp1.addSong(s5);
        mp1.addSong(s6);

        mpsl.save("eamonn");

        testloading("eamonn");


        assertTrue(mp1.getSongList().contains(s1));
        assertTrue(mp1.getSongList().contains(s2));
        assertTrue(mp1.getSongList().contains(s3));
        assertFalse(mp1.getSongList().contains(s4));

        assertTrue(mp1.getSongList().contains(s5));
        assertTrue(mp1.getSongList().contains(s6));

    }


    public void testloading(String file) throws IOException {  // DECLARE THE INTERFACE, INSTANTIATE THE IMPLEMENTATION
        try {
            mpsl.load(file);
        } catch (FileDoesntExistException e) {
            fail("Doesn't reach here!");
        }
    }

    @Test
    public void testLoadingExceptionError() throws IOException {
        mp1.addSong(s1);
        mp1.addSong(s2);
        mp1.addSong(s3);


        mp1.addSong(s5);
        mp1.addSong(s6);

        mpsl.save("eamonn");


        try {
            mpsl.load("e");
            fail("This won't run");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileDoesntExistException e) {
            return;
        }
        fail("Doesn't reach here!");
    }


}
