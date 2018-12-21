package test;

import implementations.Playlist;
import implementations.RegularSong;
import implementations.Song;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlaylist {

    private RegularSong s1;
    private RegularSong s2;
    private RegularSong s3;
    private RegularSong s4;

    private List<Song> los;

    private Playlist p1;


    @Before
    public void PlaylistSetter() {
        s1 = new RegularSong("Come as you are", "Nirvana", "In Bloom");
        s2 = new RegularSong("Time to Pretend", "MGMT", "Orangular Spectacular");
        s3 = new RegularSong("Mob Ties", "Drake", "Scorpion");
        s4 = new RegularSong("Goosebumps", "Travis Scott", "Birds in the Trap Sing McKight");

        los = new ArrayList<>();

        los.add(s1);
        los.add(s2);
        los.add(s3);
        los.add(s4);


        p1 = new Playlist("Rap", "Eamonn", los);

    }

    @Test
    public void getName() {
        assertEquals(p1.getName(), "Rap");
    }


    @Test
    public void getAuthor() {
        assertEquals(p1.getAuthor(), "Eamonn");
    }

    @Test
    public void getSongs() {
        assertEquals(p1.getSongs().size(), 4);
    }
}
