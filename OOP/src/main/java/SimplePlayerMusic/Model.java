package SimplePlayerMusic;

import java.util.ArrayList;

public class Model {
    private ArrayList<String> playlist;
    public void loadSongs() {
        playlist.add("music/BnHA_op1.wav");
        playlist.add("music/G_S2_ed3.wav");
        playlist.add("music/G_S2_ed5.wav");
        playlist.add("music/G_S2_op2.wav");
        playlist.add("music/G_S2_op4.wav");
    }
    Model() {
        playlist = new ArrayList<String>();
    }

    public void add(String fileName) {
        playlist.add(fileName);
    }

    public String get(int index) {
        return playlist.get(index);
    }

    public int getCount() {
        return playlist.size();
    }
    public void printAll() {
        for (String songName : playlist) {
            System.out.println("Song name: " + songName);
        }
    }
}