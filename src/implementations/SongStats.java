package implementations;


import java.util.ArrayList;
import java.util.List;

public class SongStats extends MusicStatistics {

    private List<MusicStatistics> musicstats =  new ArrayList<>();
    private String songName;

    public SongStats (String songName) {
        this.songName = songName;
    }

    public void addMusicStats(MusicStatistics musicStatistics) {
        musicstats.add(musicStatistics);
    }

    @Override
    public void displayData(String indentLevel) {
        System.out.println(indentLevel+songName);
        for (MusicStatistics musicStatistics : musicstats) {
            musicStatistics.displayData(indentLevel+indentLevel);
        }

    }

}
