package implementations;

import exceptions.FileDoesntExistException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.LoadSong;
import model.PlayMP3;
import model.SaveSong;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayerSaveLoad implements LoadSong, PlayMP3, SaveSong {

    private ArrayList<Song> loadSaveSongs;

    public MusicPlayerSaveLoad(MusicPlayer mp) {
        loadSaveSongs = mp.getSongList();
    }

    // this is in progress, need javaFX functionality and UI
    @Override
    public void playMP3(String songName) {
        String filePath = "/Users/eamonnkeane/Desktop/Music/" + songName + ".mp3";

    }

    // REQUIRES: valid text file in directory
    // MODIFIES: this
    // EFFECTS: loads the text file with the given name
    //           and populates it within the current songs in the playlist
    @Override
    public void load(String songFile) throws IOException, FileDoesntExistException {  // Reference: FileReaderWriter
        File songsFile = new File("/Users/eamonnkeane/Downloads/",songFile + ".txt");

        if (!songsFile.exists()) {
            throw new FileDoesntExistException();
        }

        List<String> songs = Files.readAllLines(songsFile.toPath());

        SplitAndMakeNewSong(songs); // NEW helper method


    }

    private void SplitAndMakeNewSong(List<String> songs) {
        for (String s : songs) {
            String[] split = s.split(",", 4);
            Song regularSong = new RegularSong("\n" + split[0],  split[1], split[2]);
            loadSaveSongs.add(regularSong);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new text file with the given file name
    //          and writes the list of songs to the text file
    @Override
    public void save(String songFile) throws IOException {  // Reference: FileReaderWriter

        ArrayList<String> songs = convertObjectArray();
        File songsFile = new File("/Users/eamonnkeane/Downloads/",  songFile + ".txt");
        Files.write(songsFile.toPath(), songs);

    }

    // REQUIRES: non-empty array of songs in string format
    // EFFECTS: returns an array of songs in string format
    public ArrayList<String> convertObjectArray() {
        ArrayList<Song> songs = loadSaveSongs;
        ArrayList<String> songString = new ArrayList<>();

        PrintRegOrFavSong(songs, songString); // NEW helper method

        return songString;

    }

    private void PrintRegOrFavSong(ArrayList<Song> songs, ArrayList<String> songString) {
        for (Song s : songs) {
            if (s instanceof RegularSong) {
                songString.add("Title: " + s.getTitle() + ", Artist: " + s.getArtist() + ", Album Name: " + s.getAlbumName());
            } else {
                songString.add(s.getfavSongSymbol() + "\n Title: " + s.getTitle() + ", Artist: " + s.getArtist() + ", Album Name: " + s.getAlbumName());
            }
        }
    }



}
