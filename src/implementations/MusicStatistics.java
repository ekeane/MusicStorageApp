package implementations;

import exceptions.FileDoesntExistException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class MusicStatistics  {

    public void scrapData(String filename) throws IOException { // Reference: https://edge.edx.org/courses/course-v1:UBC+CPSC210+2018W1/courseware/a4d49b3ef5fa4fe2bd9496e76d72dc48/e2887456a15a48dbb040ecdac313168f/10?activate_block_id=block-v1%3AUBC%2BCPSC210%2B2018W1%2Btype%40vertical%2Bblock%4038dc1fe6e45a420ea1936b0165c6e58d

        BufferedReader br = null;

        try {
            String theURL = "https://secondhandsongs.com/statistics";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }


            File songsFile = new File(filename + ".txt");
            Files.write(songsFile.toPath(), Collections.singleton(sb.toString()));

        } finally {

            if (br != null) {
                br.close();
            }
        }

    }

    public void parseData(String filename, String songName) throws IOException, FileDoesntExistException {   // Reference: FileReaderWriter
            File songStats = new File(filename + ".txt");

        if (!songStats.exists()) {
            throw new FileDoesntExistException();
        }

        List<String> allSongStats = Files.readAllLines(songStats.toPath());

        for (String songStat : allSongStats) {
            if (songStat.contains(songName)) {
                int indexOfSong = allSongStats.indexOf(songStat);

                System.out.println("Name of song is: " + allSongStats.get(indexOfSong).replaceAll("<[^>]*>", "")); // Reference for regex: https://stackoverflow.com/questions/4075742/regex-to-strip-html-tags
                System.out.println("Written by: " + allSongStats.get(indexOfSong+1).replaceAll("<[^>]*>", ""));
                System.out.println("Originally by: " + allSongStats.get(indexOfSong+2).replaceAll("<[^>]*>", ""));
                System.out.println("Covers: " + allSongStats.get(indexOfSong+3).replaceAll("<[^>]*>", ""));
                System.out.println("Adaptions: " + allSongStats.get(indexOfSong+4).replaceAll("<[^>]*>", ""));
            }
        }


    }

    public List<String> displayParser(String filename, String songName) throws FileDoesntExistException, IOException {
        File songStats = new File(filename + ".txt");

        if (!songStats.exists()) {
            throw new FileDoesntExistException();
        }

        List<String> allSongStats = Files.readAllLines(songStats.toPath());
        List<String> newSongStats = new ArrayList<>();

        for (String songStat : allSongStats) {
            if (songStat.contains(songName)) {
                int indexOfSong = allSongStats.indexOf(songStat);

                newSongStats.add("Name of song is: " + allSongStats.get(indexOfSong).replaceAll("<[^>]*>", "")); // Reference for regex: https://stackoverflow.com/questions/4075742/regex-to-strip-html-tags
                newSongStats.add("\nWritten by: " + allSongStats.get(indexOfSong+1).replaceAll("<[^>]*>", ""));
                newSongStats.add("\nOriginally by: " + allSongStats.get(indexOfSong+2).replaceAll("<[^>]*>", ""));
                newSongStats.add("\nCovers: " + allSongStats.get(indexOfSong+3).replaceAll("<[^>]*>", ""));
                newSongStats.add("\nAdaptions: " + allSongStats.get(indexOfSong+4).replaceAll("<[^>]*>", ""));

            }
        }

        return newSongStats;

    }

    public abstract void displayData(String indentLevel);


    public void writeStatsToFile(String filename, String songName) throws FileDoesntExistException, IOException {
        List<String> songStats  =  displayParser(filename, songName);
        File songsFile = new File("/Users/eamonnkeane/Downloads/",  songStats + ".txt");
        Files.write(songsFile.toPath(), songStats);
    }

}
